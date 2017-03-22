package smtlib;


public abstract class SExpr extends Ast {
	protected abstract void toBuilder(StringBuilder sb);
	
	public SExpr(Location loc) { super(loc); }
	
}
