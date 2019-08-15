package newYearPresent;

public interface Present {
	
	String getName();
	
	int getWeight();
	
	double getSugarContent();

	boolean isCandy();

	void setName(String name);

	void setWeight(int weight);

	void setSugarContent(double sugarContent);

	void setIsCandy(boolean isCandy);

}
