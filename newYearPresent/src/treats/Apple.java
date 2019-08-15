package treats;

public class Apple extends Treats {
	
	private String color;
	
	public Apple(String name, int weight, double sugarContent, boolean isCandy, String color) {
		super(name, weight, sugarContent, isCandy);
		
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}
