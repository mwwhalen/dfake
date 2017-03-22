package dfake;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import smtlib.Program;
import smtlib.SExpr;
import smtlib.parsing.SmtlibToAstVisitor;
import smtlib.parsing.StdErrErrorListener;
import smtlib.parsing.smtlibLexer;
import smtlib.parsing.smtlibParseException;
import smtlib.parsing.smtlibParser;
import smtlib.parsing.smtlibParser.ProgramContext;
import smtlib.parsing.smtlibParser.SexprContext;


/**
 * This class serves as a single entry point for all dfake-based command line
 * tools. This allows us to distribute a single jar for all tools. It would not
 * be enough to simply put this jar is the classpath and load the appropriate
 * main, because we rely on some third-party jars which Java is not able to load
 * out of another jar. Instead, we use Eclipse's "Export to Runnable JAR"
 * feature which comes with a jar-in-jar loader. The downside is that such
 * runnable JARs allow only a single entry point.
 */
public class Main {
	public static final String VERSION = "0.0.2";

	public static void main(String[] args) {
		String availableEntryPoints = "Available entry points: -dfake";
		if (args.length == 0) {
			StdErr.println("dFake Suite " + VERSION);
			StdErr.println(availableEntryPoints);
			System.exit(0);
		}
		String entryPoint = args[0];
		String[] subArgs = Arrays.copyOfRange(args, 1, args.length);
		switch (entryPoint) {
		case "-dfake":
			DFake.main(subArgs);
			break;


		default:
			StdErr.println("unknown entry point: " + entryPoint);
			StdErr.println(availableEntryPoints);
			System.exit(ExitCodes.UNKNOWN_ENTRY_POINT);
		}
	}

	public static Program parseSmtlib(String filename) throws Exception {
		File file = new File(filename);
		if (!file.exists() || !file.isFile()) {
			StdErr.fatal(ExitCodes.FILE_NOT_FOUND, "cannot find file " + filename);
		}
		if (!file.canRead()) {
			StdErr.fatal(ExitCodes.FILE_NOT_READABLE, "cannot read file " + filename);
		}

		StdErr.setLocationReference(readAllLines(filename));
		return parseSmtlib(new ANTLRFileStream(filename));
	}

	/* 
	 * To parse from stdIn, I'm going to have a different mainLoop behavior; 
	 * 
	 */
	// public static SExpr parseSExpr()

	private static List<String> readAllLines(String filename) {
		Path path = FileSystems.getDefault().getPath(filename);
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			return Collections.emptyList();
		}
	}

	public static Program parseSmtlib(CharStream stream) throws Exception {
		smtlibLexer lexer = new smtlibLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		smtlibParser parser = new smtlibParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new StdErrErrorListener());
		ProgramContext program = parser.program();

		if (parser.getNumberOfSyntaxErrors() > 0) {
			System.exit(ExitCodes.PARSE_ERROR);
		}

		try {
			return new SmtlibToAstVisitor().program(program);
		} catch (smtlibParseException e) {
			StdErr.fatal(ExitCodes.PARSE_ERROR, e.getLocation(), e.getMessage());
			throw e;
		}
	}


	/* Note: this SUCKS!  Need a better way to do this */
	public static SExpr parseSExpr(String s) {
		smtlibLexer lexer = new smtlibLexer(new ANTLRInputStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		smtlibParser parser = new smtlibParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new StdErrErrorListener());
		SexprContext sexpr = parser.sexpr();
		if (parser.getNumberOfSyntaxErrors() > 0) {
			System.exit(ExitCodes.PARSE_ERROR);
		}
		try {
			return new SmtlibToAstVisitor().sexpr(sexpr);
		} catch (smtlibParseException e) {
			StdErr.fatal(ExitCodes.PARSE_ERROR, e.getLocation(), e.getMessage());
			throw e;
		}
	}

}
