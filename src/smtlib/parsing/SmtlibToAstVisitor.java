package smtlib.parsing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import smtlib.Cons;
import smtlib.Keyword;
import smtlib.Location;
import smtlib.Program;
import smtlib.SExpr;
import smtlib.SpecConstant;
import smtlib.Symbol;
import smtlib.parsing.smtlibParser.ProgramContext;
import smtlib.parsing.smtlibParser.SexprContext;
import smtlib.values.BigFraction;
import smtlib.values.IntegerValue;
import smtlib.values.RealValue;
import smtlib.values.StringValue;

public class SmtlibToAstVisitor extends smtlibBaseVisitor<Object> {

   public Program program(ProgramContext ctx) {
      List<SExpr> sexprs = sexprs(ctx.sexpr()); 
      return new Program(loc(ctx), sexprs);
   }

   public SExpr sexpr(SexprContext ctx) {
	   return (SExpr)ctx.accept(this);
   }
   
   public List<SExpr> sexprs(List<SexprContext> sctxts) {
      return sctxts.stream().map(
            ctx -> (SExpr)ctx.accept(this)).collect(Collectors.toList());
   }
   
   
   @Override 
   public SExpr visitNumeralConstant(smtlibParser.NumeralConstantContext ctx) { 
      return new SpecConstant(loc(ctx), 
            new IntegerValue(new BigInteger(ctx.NUMERAL().getText())));
   }
      
   public SExpr visitRealConstant(smtlibParser.RealConstantContext ctx) {
      return new SpecConstant(loc(ctx),
            new RealValue(BigFraction.valueOf(new BigDecimal(ctx.REAL().getText()))));
   }
   
   @Override 
   public SExpr visitHexConstant(smtlibParser.HexConstantContext ctx) { 
      String hexStr = ctx.HEX().getText().replace("#x", "0x");
      long hexVal = Integer.decode(hexStr);
      return new SpecConstant(loc(ctx),
            new IntegerValue(BigInteger.valueOf(hexVal)));
   }

   @Override
   public SExpr visitBinConstant(smtlibParser.BinConstantContext ctx) {
      String binStr = ctx.BIN().getText().replace("#b", "0b");
      long binVal = Integer.decode(binStr);
      return new SpecConstant(loc(ctx),
            new IntegerValue(BigInteger.valueOf(binVal)));
   }
   
   @Override 
   public SExpr visitStringConstant(smtlibParser.StringConstantContext ctx) { 
      
	  String s = ctx.STRING().getText();
	  s = s.trim();
	  s = s.substring(1, s.length()-1);
	  // System.out.println("String: " + s);
	  return new SpecConstant(loc(ctx), new StringValue(s));
   }

   @Override
   public SExpr visitSymbol(smtlibParser.SymbolContext ctx) {
      return new Symbol(loc(ctx), ctx.getText()); 
   }
  
   @Override
   public SExpr visitKeyword(smtlibParser.KeywordContext ctx) {
      return new Keyword(loc(ctx), ctx.getText()); 
   }

   public SExpr visitCons(smtlibParser.ConsContext ctx) {
      List<SexprContext> elems = ctx.sexpr();
      List<SExpr> args = elems.stream().map(
            elem -> (SExpr)elem.accept(this)).collect(Collectors.toList());
      return new Cons(loc(ctx), args);
   }   

   protected Location loc(ParserRuleContext ctx) {
      Token token = ctx.getStart();
      return new Location(token.getLine(), token.getCharPositionInLine());
   }
/*
   private void fatal(ParserRuleContext ctx, String text) {
      throw new smtlibParseException(loc(ctx), text);
   }
   */
}
