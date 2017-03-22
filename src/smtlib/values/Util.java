package smtlib.values;

import java.math.BigInteger;

public class Util {

   /**
    * In SMT solvers, integer division behaves differently than in Java. In
    * particular, for -5 div 3 java says '-1' and SMT solvers say '-2'
    */
   public static BigInteger smtDivide(BigInteger a, BigInteger b) {
      return a.subtract(a.mod(b)).divide(b);
   }

   public static String removeTrailingZeros(String str) {
      if (!str.contains(".")) {
         return str;
      }

      return str.replaceFirst("\\.?0*$", "");
   }

}
