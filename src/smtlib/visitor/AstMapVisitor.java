package smtlib.visitor;

import java.util.List;
import java.util.stream.Collectors;

import smtlib.Ast;
import smtlib.Cons;
import smtlib.Keyword;
import smtlib.Program;
import smtlib.SExpr;
import smtlib.SpecConstant;
import smtlib.Symbol;

public class AstMapVisitor implements AstVisitor<Ast> {

   @Override
   public Ast visit(Program e) {
      // TODO Auto-generated method stub
      List<SExpr> sexprs = e.sexprs.stream()
            .map(elem -> (SExpr)elem.accept(this))
            .collect(Collectors.toList());
      return new Program(e.location, sexprs);
   }

   @Override
   public Ast visit(Keyword e) {
      return e;
   }

   @Override
   public Ast visit(SpecConstant e) {
      return e;
   }

   @Override
   public Ast visit(Symbol e) {
      return e;
   }


   @Override
   public Ast visit(Cons e) {
      List<SExpr> args = e.args.stream()
            .map(elem -> (SExpr)elem.accept(this))
            .collect(Collectors.toList());
      return new Cons(e.location, args);
   }
}
