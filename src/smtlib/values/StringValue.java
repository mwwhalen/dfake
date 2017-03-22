package smtlib.values;

import smtlib.BinaryOp;
import smtlib.UnaryOp;

public class StringValue extends Value {

   public final String str;
   
   public StringValue(String str) {
      this.str = str;
   }
   
   @Override
   public Value applyBinaryOp(BinaryOp op, Value right) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Value applyUnaryOp(UnaryOp op) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String toString() {
      return str;
   }
}
