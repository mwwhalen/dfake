// Generated from smtlib.g4 by ANTLR 4.6
package smtlib.parsing;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link smtlibParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface smtlibVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link smtlibParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(smtlibParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tl}
	 * labeled alternative in {@link smtlibParser#toplevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTl(smtlibParser.TlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sConstant}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSConstant(smtlibParser.SConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sym}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSym(smtlibParser.SymContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kw}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKw(smtlibParser.KwContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cons}
	 * labeled alternative in {@link smtlibParser#sexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(smtlibParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numeralConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeralConstant(smtlibParser.NumeralConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealConstant(smtlibParser.RealConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hexConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexConstant(smtlibParser.HexConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinConstant(smtlibParser.BinConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link smtlibParser#spec_constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(smtlibParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link smtlibParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(smtlibParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link smtlibParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(smtlibParser.KeywordContext ctx);
}