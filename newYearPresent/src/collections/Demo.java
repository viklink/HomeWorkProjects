package collections;

import java.util.ArrayList;
import java.util.ListIterator;
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
/*
		myPrayer.clear();
		if (myPrayer.size() == 0) {
			System.out.println("The List is cleared");
		} else {
			System.out.println("Check your code");
		}
*/	
		Iterator<String> iter = myPrayer.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for (String word : myPrayer) {
			System.out.print(word + " ");
		}
		
		DefaultMyList con = new DefaultMyList ();
		Iterator<Object> it = con.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		
		ListIterator<String> listIterator = myPrayer.listIterator();
        while (listIterator.hasNext()) {
            String word = listIterator.next();
            listIterator.set(word + " ");
        }
		
		while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
		
        listIterator.next();
 
        listIterator.remove();
        System.out.println("After remove(): " + myPrayer);

	}
	

}
