package smtlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import smtlib.values.BooleanValue;
import smtlib.visitor.AstVisitor;

public class Cons extends SExpr {
	public final List<? extends SExpr> args;

	public Cons(Location loc, List<? extends SExpr> args) {
		super(loc);
		this.args = args;
	}
	
   public Cons(Location loc, SExpr hd, List<? extends SExpr> args) {
      super(loc);
      List<SExpr> l = new ArrayList<>(); 
      l.add(hd); 
      l.addAll(args);
      this.args = l;
   }

   public Cons(Location loc, SExpr hd, SExpr... args) {
      this(loc, hd, Arrays.asList(args));
   }

   public SExpr head() { return args.get(0); }
   public List<? extends SExpr> tail() { return args.subList(1, args.size()); }
   public boolean isNil() { return args.isEmpty(); }

   public static Cons NIL = new Cons(Location.NULL, new ArrayList<>()); 
   
   public static Cons ASSERT_TRUE = new Cons(Location.NULL, 
        new Symbol(Location.NULL, "assert"),
        new SpecConstant(Location.NULL, BooleanValue.TRUE));
   
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toBuilder(sb);
		return sb.toString();
	}

	@Override
	protected void toBuilder(StringBuilder sb) {
		sb.append("(");
		for (SExpr arg : args) {
			arg.toBuilder(sb);
         sb.append(" ");
		}
		sb.append(")");
	}

   @Override
   public <T> T accept(AstVisitor<T> visitor) {
      return visitor.visit(this);
   }
   
   
   // methods related to function conses
   public Symbol functionName() {
      return (Symbol)args.get(1); 
   }
   
   public Cons functionParameters() {
      return (Cons)args.get(2); 
   }
  
   public SExpr functionType() {
      return args.get(3); 
   }
   
   public SExpr functionBody() {
      return args.get(4);
   }

//   public String parameterName() {
//      return head().toString(); 
//   }
}
