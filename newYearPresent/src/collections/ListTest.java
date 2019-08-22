package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		List<Integer> arrList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		for (int i = 0; i < 1000000; i++) {
			arrList.add(i + 1);
			//System.out.print(i + " ");
		}
		
		for (int j = 1; j <= 1000000; j++) {
			linkedList.add(j + 1);
		}
		
		long mill = System.currentTimeMillis();
		for (int i = 1; i <= 1000000; i++) {
			//arrList.add(0, i); // добавляем элементы в начало списка
			//arrList.add(arrList.size()/2, i); //добавляем элементы в середину списка
			//arrList.add(i); //добавляем элементы в конец списка
			//arrList.remove(0); // удаляем элементы из начала списка
			arrList.remove(arrList.size()/2); //удаляем элементы из середины списка
			//arrList.remove(arrList.size()-1); // удаляем элементы из конца списка
		}
		long delta = System.currentTimeMillis() - mill;
		System.out.println(delta);
		
		long millis = System.currentTimeMillis();
		for (int j = 1; j <= 1000000; j++) {
			//linkedList.addFirst(j); // добавляем элементы в начало списка
			//linkedList.add(linkedList.size()/2, j); //добавляем элементы в середину списка
			//linkedList.addLast(j); // добавляем элементы в конец списка
			//linkedList.removeFirst();
			linkedList.remove(linkedList.size()/2);
			//linkedList.removeLast();
		}
		long deltaT = System.currentTimeMillis() - millis;
		System.out.println(deltaT);

	}
	
}
