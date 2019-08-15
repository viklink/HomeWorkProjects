package newYearPresent;
import java.util.Comparator;

public class WeightComparator implements Comparator<Present> {

	@Override
	public int compare(Present p1, Present p2) {
		if (p1.getWeight() == p2.getWeight()) {
			return 0;
		}
		
		if (p1.getWeight() > p2.getWeight()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
