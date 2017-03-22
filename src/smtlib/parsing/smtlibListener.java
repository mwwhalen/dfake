// Generated from smtlib.g4 by ANTLR 4.6
package smtlib.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link smtlibParser}.
 */
public interface smtlibListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link smtlibParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(smtlibParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link smtlibParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(smtlibParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tl}
	 * labeled alternative in {@link smtlibParser#toplevel}.
	 * @param ctx the parse tree
	 */
	void enterTl(smtlibParser.TlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tl}
	 * labeled alternative in {@link smtlibParser#toplevel}.
	 * @param ctx the parse tree
	 */
	void exitTl(smtlibParser.TlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sConstant}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void enterSConstant(smtlibParser.SConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sConstant}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void exitSConstant(smtlibParser.SConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sym}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void enterSym(smtlibParser.SymContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sym}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void exitSym(smtlibParser.SymContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kw}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void enterKw(smtlibParser.KwContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kw}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void exitKw(smtlibParser.KwContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cons}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void enterCons(smtlibParser.ConsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cons}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void exitCons(smtlibParser.ConsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numeralConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void enterNumeralConstant(smtlibParser.NumeralConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numeralConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void exitNumeralConstant(smtlibParser.NumeralConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void enterRealConstant(smtlibParser.RealConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void exitRealConstant(smtlibParser.RealConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hexConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void enterHexConstant(smtlibParser.HexConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hexConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void exitHexConstant(smtlibParser.HexConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void enterBinConstant(smtlibParser.BinConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void exitBinConstant(smtlibParser.BinConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(smtlibParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(smtlibParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link smtlibParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(smtlibParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link smtlibParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(smtlibParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link smtlibParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(smtlibParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link smtlibParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(smtlibParser.KeywordContext ctx);
}