package smtlib.visitor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import smtlib.Ast;
import smtlib.Cons;
import smtlib.Location;
import smtlib.Program;
import smtlib.SExpr;
import smtlib.SpecConstant;
import smtlib.Symbol;
import smtlib.values.IntegerValue;

public class FlattenVisitor extends AstMapVisitor {

   // Environment management functions
   Deque<List<SExpr>> env = null;
   
   public FlattenVisitor() {
      env = new ArrayDeque<>();
      // add first level to the environment
      env.push(new ArrayList<>());
   }
   
   public void push(int k) {
      if (k > 0) {
         env.push(new ArrayList<>());
         push(k-1); 
      }
   }
   
   public void add(SExpr e) {
      env.peek().add(e);
   }
   
   public void pop(int k) {
      if (k > 0 && env.size() > 1) {
         env.pop();
         pop(k-1);
      }
   }
   
   public List<SExpr> emit() {
      List<SExpr> inorder = new ArrayList<>(); 
      
      for (Iterator<List<SExpr>> it = env.descendingIterator(); it.hasNext(); ) { 
         inorder.addAll(it.next());
      }
      return inorder;
   }
   
   public int decodeDepth(Cons c) {
      if (c.args.size() == 1) {
         return 1; 
      } else {
         IntegerValue val = (IntegerValue)((SpecConstant)c.args.get(1)).val;
         return Integer.decode(val.toString()); 
      }
   }
   
   public void visitTopLevel(SExpr e) {
      if (e instanceof Cons) {
         Cons c = (Cons)e;
         String hdStr = c.head().toString(); 
         if (hdStr.equals("push")) {
            push(decodeDepth(c));
            return;
         } else if (hdStr.equals("pop")) {
            pop(decodeDepth(c));
            return;
         }
      }
      // else...add to the current stack level.
      add(e);
   }
   
   
   @Override
   public Ast visit(Program p) {
      p.sexprs.stream().forEach(sexp -> visitTopLevel(sexp));
      return new Program(p.location, emit());
   }
   
   public static Program Program(Program p) {
      FlattenVisitor v = new FlattenVisitor(); 
      return (Program)v.visit(p);
   }
   
   public static Program ProgramExit(Program p) {
      FlattenVisitor v = new FlattenVisitor(); 
      p.sexprs.stream().forEach(sexp -> v.visitTopLevel(sexp));
      List<SExpr> l = v.emit(); 
      l.add(new Cons(Location.NULL, new Symbol(Location.NULL, "exit")));
      return new Program(p.location, l);
   }
}
