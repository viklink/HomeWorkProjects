package newYearPresent;

import java.util.ArrayList;
import java.util.List;

public interface PresentManager {
	List<Present> newYearPresent = new ArrayList<>();
	
	List<Present> addPresent(Present present);
	int getTotalWeight(List<Present> newYearPresent);
	Present findPresentBySugarContent(double sugarContent, List<Present> newYearPresent);
	void sortPresents(WeightComparator myWeightComparator, List<Present> newYearPresent);
	
}
