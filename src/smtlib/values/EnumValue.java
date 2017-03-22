package smtlib.values;

import smtlib.BinaryOp;
import smtlib.UnaryOp;

/**
 * An enumerated value (only used during counter-example output)
 */
public class EnumValue extends Value {
	public final String value;

	public EnumValue(String value) {
		this.value = value;
	}

	@Override
	public Value applyBinaryOp(BinaryOp op, Value right) {
		return null;
	}

	@Override
	public Value applyUnaryOp(UnaryOp op) {
		return null;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnumValue) {
			EnumValue other = (EnumValue) obj;
			return value.equals(other.value);
		}
		return false;
	}
}
