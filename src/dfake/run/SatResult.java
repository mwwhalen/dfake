package dfake.run;

public class SatResult extends Result {
	final private String model;

	public SatResult(String model) {
		super();
		// ditch the first line saying "sat".  
		model = model.replaceFirst("sat" + System.lineSeparator(), "");
		this.model = model;
	}
	
	public SatResult() {
		this(null);
	}

	public String getModel() {
		return model;
	}
	
	public String toString() {	
	   return model;
	}
}
