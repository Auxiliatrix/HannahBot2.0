package tokens;

// TODO: Not yet implemented

public class AltName {
	public String name;
	private int right;
	private int total;
	
	public AltName() {
		name = "";
		right = 0;
		total = 0;
	}
	public AltName(String name) {
		this.name = name;
		right = 0;
		total = 0;
	}
	
	public void associate() {
		right++;
		total++;
	}
	public void disassociate() {
		total++;
	}
	
	public double getValue() {
		if( total == 0 ) {
			return 0;
		} else {
			return right / total;
		}
	}
}
