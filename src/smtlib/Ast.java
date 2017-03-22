package smtlib;

import dfake.Assert;
//import jkind.lustre.visitors.AstVisitor;
import smtlib.visitor.AstVisitor;

public abstract class Ast {
   public final Location location;

   public Ast(Location location) {
      Assert.isNotNull(location);
      this.location = location;
   }

   public abstract <T> T accept(AstVisitor<T> visitor);

   // public abstract <T, S extends T> T accept(AstVisitor<T, S> visitor);
}
