package smtlib.visitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import dfake.Assert;
import smtlib.Ast;
import smtlib.Cons;
import smtlib.Program;
import smtlib.SExpr;
import smtlib.SpecConstant;
import smtlib.Symbol;
import smtlib.values.IntegerValue;

public class InlineFunctionVisitor extends AstMapVisitor {

   // Environment management functions
   Deque<HashMap<String, SExpr>> env = null;
   
   public SExpr lookup(String name) {
      for (HashMap<String, SExpr> level: env) {
         if (level.containsKey(name)) {
            return level.get(name);
         }
      }
      return null;
   }
   
   public void put(String key, SExpr value) {
      env.peek().put(key, value);
   }
   
   public void putNull(String key) {
      put(key, null);
   }
   
   public void pushFrame(HashMap<String, SExpr> frame) {
      env.push(frame);
   }
   
   public InlineFunctionVisitor() {
      env = new ArrayDeque<>();
      // add first level to the environment
      env.push(new HashMap<>());
   }
   
   public void push(int k) {
      if (k > 0) {
         env.push(new HashMap<>());
         push(k-1); 
      }
   }
   
   public void pop(int k) {
      if (k > 0 && env.size() > 1) {
         env.pop();
         pop(k-1);
      }
   }
   
   // Note: we should only get here when we are evaluating the body 
   // of assertions or define-funs.  We scan for function calls and 
   // replace them with their bodies.
   @Override
   public SExpr visit(Cons c) {
      if (c.isNil()) {
         return c; 
      } else {
         SExpr envVal = lookup(c.head().toString()); 
         if (envVal == null || !(envVal instanceof Cons)) {
            return (SExpr)super.visit(c);
         } else {
            Cons functionDef = (Cons)envVal;
            // match.  Push stack and map formals to actual parameters.
            // create a new Stack frame.  Evaluate arguments in their 
            // context, then push the frame onto the stack.
            HashMap<String, SExpr> fnCtxt = new HashMap<>(); 
            
            Iterator<? extends SExpr> formals = 
                  ((Cons)envVal).functionParameters().args.iterator(); 
            for (SExpr actual: c.tail()) {
               String formal = ((Cons)(formals.next())).head().toString();
               fnCtxt.put(formal, (SExpr)actual.accept(this));
            }
            
            // check argument list lengths match.
            Assert.isFalse(formals.hasNext());
            
            // push stack, evaluate body, then pop and return.
            pushFrame(fnCtxt); 
            SExpr expr = (SExpr)functionDef.functionBody().accept(this);
            pop(1);
            // System.out.println("Created expr: " + expr.toString());
            return expr;
         }
      }
   }

   public SExpr visit(Symbol e) {
      SExpr actual = lookup(e.str);
      if (actual == null) {
         return e;
      } else {
         return actual;
      }
   }
   
   public int decodeDepth(Cons c) {
      if (c.args.size() == 1) {
         return 1; 
      } else {
         IntegerValue val = (IntegerValue)((SpecConstant)c.args.get(1)).val;
         return Integer.decode(val.toString()); 
      }
   }
   
   public void visitDefineFun(Cons c) {
      String fnName = c.functionName().toString(); 

      // push args to env to avoid capture.
      push(1);
      Cons fnArgs = c.functionParameters(); 
      for (SExpr arg: fnArgs.args) {
         Cons param = (Cons)arg; 
         putNull(param.head().toString());
      }
      
      // evaluate body as normal.
      SExpr fnBody = (SExpr)c.functionBody().accept(this); 
      
      // pop off arguments
      pop(1);
      
      put(fnName, 
            new Cons(c.location, 
                  c.head(), 
                  c.functionName(), 
                  c.functionParameters(),
                  c.functionType(), 
                  fnBody));
   }
   
   public SExpr visitTopLevel(SExpr e) {
      if (e instanceof Cons) {
         Cons c = (Cons)e;
         String hdStr = c.head().toString(); 
         if (hdStr.equals("define-fun")) {
            visitDefineFun(c);
            return Cons.ASSERT_TRUE;
         } else if (hdStr.equals("assert")) {
            List<SExpr> assertBody = c.args.subList(1, c.args.size()).stream()
               .map(elem -> (SExpr)elem.accept(this)).collect(Collectors.toList());
            return new Cons(c.location, c.head(), assertBody);
         } else if (hdStr.equals("declare-fun")) {
            // avoid capture
            putNull(c.args.get(1).toString());
         } else if (hdStr.equals("push")) {
            push(decodeDepth(c));
         } else if (hdStr.equals("pop")) {
            pop(decodeDepth(c));
         }
         // else...we don't care.
      }
      return e;
   }
   
   @Override
   public Ast visit(Program e) {
      return new Program(e.location, 
            e.sexprs.stream()
               .map(sexp -> visitTopLevel(sexp))
               .collect(Collectors.toList()));
   }
   
   public static Program Program(Program p) {
      InlineFunctionVisitor v = new InlineFunctionVisitor(); 
      return (Program)v.visit(p);
   }
}
