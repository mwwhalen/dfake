package smtlib;

import java.util.List;

import smtlib.visitor.AstVisitor;

public class Program extends Ast {

   public final List<SExpr> sexprs; 
   // public final List<SExpr> types;
   public Program(Location location, List<SExpr> sexprs) {
      super(location);
      this.sexprs = sexprs;
   }
   
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder(); 
      sexprs.stream().forEach(
            elem -> builder.append(elem.toString()).append(System.lineSeparator()));
      return builder.toString();
   }

   @Override
   public <T> T accept(AstVisitor<T> visitor) {
      return visitor.visit(this);
   }
}
