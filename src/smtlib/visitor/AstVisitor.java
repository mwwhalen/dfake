package smtlib.visitor;

import smtlib.Cons;
import smtlib.Keyword;
import smtlib.Program;
import smtlib.SpecConstant;
import smtlib.Symbol;

public interface AstVisitor<T> {
   public T visit(Program e);
   public T visit(Keyword  e); 
   public T visit(SpecConstant e);
   public T visit(Symbol e);
   public T visit(Cons e);
}
