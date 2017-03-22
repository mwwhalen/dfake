package smtlib.parsing;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import dfake.StdErr;
import smtlib.Location;

public class StdErrErrorListener extends BaseErrorListener {
   @Override
   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
         int charPositionInLine, String msg, RecognitionException e) {
      StdErr.println("Parse error line " + line + ":" + charPositionInLine + " " + msg);
      StdErr.showLocation(new Location(line, charPositionInLine));
   }
}

