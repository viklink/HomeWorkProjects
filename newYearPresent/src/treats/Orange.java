package treats;

public class Orange extends Treats {
	
	private String color;

	public Orange(String name, int weight, double sugarContent, boolean isCandy, String color) {
		super(name, weight, sugarContent, isCandy);
		
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
