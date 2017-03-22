package dfake;


public class Assert {
	public static void isNotNull(Object o) {
		if (o == null) {
			throw new DFakeException("Object unexpectedly null");
		}
	}

	public static void isTrue(boolean b) {
		if (!b) {
			throw new DFakeException("Assertion failed");
		}
	}

	public static void isFalse(boolean b) {
		if (b) {
			throw new DFakeException("Assertion failed");
		}
	}
}
