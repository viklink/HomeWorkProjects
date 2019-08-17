package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		String str = "Господи помоги мне выучить Java";
		String[] prayer = str.split(" ");

		List<String> myPrayer = new ArrayList<String>(Arrays.asList(prayer));
		for (String s : myPrayer) {
			System.out.print(s + " ");
		}

		myPrayer.add("пожалуйста");
		for (String s : myPrayer) {
			System.out.print(s + " ");
		}

		myPrayer.remove("мне");
		System.out.println("The word is removed " + myPrayer.toString());

		System.out.println(myPrayer.indexOf("мне"));

		String[] myStr = myPrayer.toArray(new String[myPrayer.size()]);
		System.out.println(Arrays.deepToString(myStr));

		System.out.println(myPrayer.size());

		System.out.println(myPrayer.contains("мне"));

		System.out.println(myPrayer.containsAll(myPrayer));

		myPrayer.clear();
		if (myPrayer.size() == 0) {
			System.out.println("The List is cleared");
		} else {
			System.out.println("Check your code");
		}

	}

}
