package newYearPresent;

import java.util.ArrayList;
import java.util.List;

import treats.Treats;
import treats.Apple;
import treats.Caramel;
import treats.Chocolate;
import treats.Lollipop;
import treats.Orange;

public class Main {
	
	public static void main(String[] args) {
		
		List<Present> newYearPresent = new ArrayList<>();
		WeightComparator myWeightComparator = new WeightComparator();
		
		PresentManager manager = new PresentManagerImpl();
		Present caramel = new Treats("barbaris", 30, 70.5, true);
		Present chocolate = new Treats("choco", 50, 50, true);
		Present lollipop = new Treats("lol", 45, 60, true);
		Present orange = new Orange("orange", 250, 30, false, "orange");
		Present apple = new Apple("apple", 100, 35, false, "red");
		
		
		newYearPresent.add(caramel);
		newYearPresent.add(chocolate);
		newYearPresent.add(lollipop);
		newYearPresent.add(orange);
		newYearPresent.add(apple);
		newYearPresent.toString();
		
		for (Present p : newYearPresent) {
			System.out.println(p);
			}
			
		System.out.println(manager.getTotalWeight(newYearPresent));
		System.out.println(manager.findPresentBySugarContent(30, newYearPresent));
		manager.sortPresents(myWeightComparator, newYearPresent);
		
	}
}
