package dfake;

import java.util.ArrayList;
import java.util.List;

import smtlib.Location;


public class StdErr {
	private static List<String> locationReference = new ArrayList<>();

   public static String spaces(int n) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
         sb.append(' ');
      }
      return sb.toString();
   }

   public static void setLocationReference(List<String> locationReference) {
		StdErr.locationReference = locationReference;
	}
   
   public static void addLocationReference(String locationReference) {
      StdErr.locationReference.add(locationReference);
   }

	public static void warning(String text) {
		output(Level.WARNING, text);
	}

	public static void warning(Location loc, String text) {
		output(Level.WARNING, loc, text);
	}

	public static void error(String text) {
		output(Level.ERROR, text);
	}

	public static void error(Location loc, String text) {
		output(Level.ERROR, loc, text);
	}

	public static void fatal(int exitCode, String text) {
		error(text);
		System.exit(exitCode);
	}

	public static void fatal(int exitCode, Location loc, String text) {
		error(loc, text);
		System.exit(exitCode);
	}

	public static void output(Level level, String text) {
		if (level != Level.IGNORE) {
			println(level + " " + text);
		}
	}

	public static void output(Level level, Location loc, String text) {
		if (level != Level.IGNORE) {
			println(level + " at line " + loc + " " + text);
			if (level == Level.ERROR) {
				showLocation(loc);
			}
		}
	}

	public static void showLocation(Location loc) {
		if (1 <= loc.line && loc.line <= locationReference.size()) {
			String line = locationReference.get(loc.line - 1);
			StdErr.println(line);
			StdErr.println(spaces(loc.charPositionInLine) + "^");
		}
	}

	public static void println(String text) {
		System.err.println(text);
	}

	public static void printStackTrace(Throwable t) {
		t.printStackTrace(System.err);
	}
}
