package newYearPresent;

import java.util.ArrayList;
import java.util.List;

import treats.Caramel;
import treats.Treats;

public class PresentManagerImpl implements PresentManager {

	private List<Present> newYearPresent = new ArrayList<>();
	private String name;
	private int weight;
	private double sugarContent;
	private boolean isCandy;
	
	@Override
	public List<Present> addPresent(Present present) {
		present.setName(name);
		present.setWeight(weight);
		present.setSugarContent(sugarContent);
		present.setIsCandy(isCandy);
		newYearPresent.add(present);
		return newYearPresent;
	}

	@Override
	public int getTotalWeight(List<Present> newYearPresent) {
		int totalWeight = 0;
		for (Present present : newYearPresent) {
			totalWeight += present.getWeight();
		}
		return totalWeight;
		
	}

	@Override
	public Present findPresentBySugarContent(double sugarContent, List<Present> newYearPresent) {
	
		for (Present sugarPresent : newYearPresent) {
			if (sugarPresent.getSugarContent() == sugarContent) {
				System.out.println(sugarPresent);
			} 
		}
		return null;
	}

	@Override
	public void sortPresents(WeightComparator myWeightComparator, List<Present> newYearPresent) {
		myWeightComparator = new WeightComparator();
		newYearPresent.sort(myWeightComparator);
		System.out.println("Sorted by weight: ");
		for (Present p : newYearPresent) {
			System.out.println(p);
		}
	}


}
