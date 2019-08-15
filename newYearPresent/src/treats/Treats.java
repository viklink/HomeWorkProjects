package treats;

import newYearPresent.Present;

public class Treats implements Present {
	private String name;
	private int weight;
	private double sugarContent;
	private boolean isCandy;
	
	public Treats(String name, int weight, double sugarContent, boolean isCandy) {
		
		this.name = name;
		this.weight = weight;
		this.sugarContent = sugarContent;
		this.isCandy = isCandy;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public double getSugarContent() {
		return sugarContent;
	}
	
	public void setSugarContent(double sugarContent) {
		this.sugarContent = sugarContent;
	}

	@Override
	public boolean isCandy() {
		return isCandy();
	}
	
	@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Present{");
        sb.append("name: ").append(name);
        sb.append(", weight: ").append(weight);
        sb.append(", sugar content: ").append(sugarContent);
        sb.append(", isCandy: ").append(isCandy);
        sb.append('}');
        return sb.toString();
    }

	@Override
	public void setIsCandy(boolean isCandy) {
	}

}
