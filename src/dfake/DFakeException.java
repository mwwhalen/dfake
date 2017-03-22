package dfake;

/**
 * An exception generated from JKind or the JKind API
 */
public class DFakeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DFakeException(String message) {
		super(message);
	}
	
	public DFakeException(String message, Throwable t) {
		super(message, t);
	}
}
