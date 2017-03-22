package smtlib.parsing;

import dfake.DFakeException;
import smtlib.Location;

public class smtlibParseException extends DFakeException {
	private static final long serialVersionUID = 1L;

	private final Location loc;

	public smtlibParseException(Location loc, String text) {
		super(text);
		this.loc = loc;
	}
	
	public Location getLocation() {
		return loc;
	}
}
