package dfake.run;

public class UnknownResult extends Result {
	final private String model;

	public UnknownResult(String model) {
		super();
		this.model = model;
	}

	public UnknownResult() {
		this(null);
	}

	public String getModel() {
		return model;
	}
	
	public String toString() {
	   return "unknown" + System.lineSeparator() + 
	         ((model == null) ? "" : model); 
	}
}
