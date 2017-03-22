package smtlib.visitor;

import smtlib.Program;
import smtlib.SExpr;
import smtlib.Symbol;

public class RemoveDivVisitor extends AstMapVisitor {

   
   public RemoveDivVisitor() { }

   public SExpr visit(Symbol e) {
	   if (e.toString().equals("div")) {
		   return new Symbol(e.location, "/");
	   } else {
		   return e;
	   }
   }
   
   public static Program Program(Program p) {
      RemoveDivVisitor v = new RemoveDivVisitor(); 
      return (Program)v.visit(p);
   }
}
