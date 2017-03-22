package smtlib;

import java.math.BigInteger;

import smtlib.values.BooleanValue;
import smtlib.values.IntegerValue;
import smtlib.values.Value;
import smtlib.visitor.AstVisitor;

public class SpecConstant extends SExpr {

   public final Value val;
   public SpecConstant(Location loc, Value val) {
      super(loc); 
      this.val = val;
   }

   public static SpecConstant fromInt(int i) {
      return new SpecConstant(Location.NULL, new IntegerValue(BigInteger.valueOf(i)));
   }

   public static SExpr fromBigInt(BigInteger i) {
      return new SpecConstant(Location.NULL, new IntegerValue(i));
   }

   public static SExpr fromBoolean(boolean b) {
      return new SpecConstant(Location.NULL, BooleanValue.fromBoolean(b));
   }

   @Override
   protected void toBuilder(StringBuilder sb) {
      sb.append(val.toString());
   }

   @Override
   public String toString() {
	   return val.toString();
   }
   
   @Override
   public <T> T accept(AstVisitor<T> visitor) {
      return visitor.visit(this);
   }
}
