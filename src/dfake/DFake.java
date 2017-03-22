package dfake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dfake.run.MainLoop;
import smtlib.Program;
import smtlib.SExpr;

public class DFake {

	public static void main(String[] args) {
		DFakeSettings settings = DFakeArgumentParser.parse(args);

		if (settings.stdIn) {
			try {
				BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
				MainLoop ml = new MainLoop(settings);
				while (true) {
				    String line = stdin.readLine();
				    if (line == null) {
				        System.exit(0);
				    }
					SExpr se = Main.parseSExpr(line);
					ml.addSExpr(se);
				}  
			} catch (IOException ioe) {
				StdErr.fatal(ExitCodes.STDIN_NOT_READABLE, ioe.toString());
			} catch (Exception e) {
				StdErr.fatal(ExitCodes.PARSE_ERROR, e.toString());
			}
		}
		else {
			String filename = settings.filename; 
			try {
				Program prog = Main.parseSmtlib(filename);
				// System.out.println("Program: \n" + prog.toString());
				MainLoop ml = new MainLoop(settings);
				for (SExpr se: prog.sexprs) {
					ml.addSExpr(se);
				}
			} catch (Exception e) {
				StdErr.fatal(ExitCodes.PARSE_ERROR, e.toString());
			}
		}
	}


}
