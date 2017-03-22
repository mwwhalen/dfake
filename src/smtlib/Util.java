package smtlib;

public class Util {

   public static boolean consHeadMatchesString(SExpr sexpr, String hd) {
      if (sexpr instanceof Cons) {
         Cons c = (Cons)sexpr;
         if (!c.isNil()) {
            return c.head().toString().equals(hd);
         }
      }
      return false;
   }
}
