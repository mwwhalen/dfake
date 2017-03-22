package smtlib;

import smtlib.visitor.AstVisitor;

public class Symbol extends SExpr {
	public final String str;

	public Symbol(Location loc, String sym) {
	   super(loc);
		this.str = sym;
	}

	public boolean isQuoted() {
	   return (str.charAt(0) == '|');
	}

	
	public String unquoted() {
	   if (isQuoted()) {
	      return str.substring(1, str.length()-2);
	   } else {
	      return str;
	   }
	}
	
	@Override
	public String toString() {
		return str;
	}

	@Override
	protected void toBuilder(StringBuilder sb) {
		sb.append(str);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Symbol)) {
			return false;
		}
		Symbol other = (Symbol) obj;
		if (str == null) {
			if (other.str != null) {
				return false;
			}
		} else if (!str.equals(other.str)) {
			return false;
		}
		return true;
	}

   @Override
   public <T> T accept(AstVisitor<T> visitor) {
      return visitor.visit(this);
   }
}
