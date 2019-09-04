package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Matrix implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int[][] array = new int[4][100];
		int maxNumber = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 101);
				if (maxNumber <= array[i][j]) {
					maxNumber = array[i][j];
				}
				Thread.sleep(1);
			}
		}
		return maxNumber;
	}
	
	public void test() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		Callable<Integer> callable = new Matrix();
		for (int i = 0; i < 10; i++) {
			Future<Integer> future = executor.submit(callable);
			results.add(future);
		}
		for (Future<Integer> result : results) {
			System.out.println(result.get());
		}
		executor.shutdown();
	}
	public static void main(String[] args) throws java.lang.Exception {
		long mill = System.currentTimeMillis();
		new Matrix().test();
		long delta = System.currentTimeMillis() - mill;
		System.out.println(delta);
		
		long millis = System.currentTimeMillis();
		int[][] array = new int[4][100];
		int maxNumber = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 101);
				if (maxNumber <= array[i][j]) {
					maxNumber = array[i][j];
				}
			}
		}
		System.out.println(maxNumber);
		long deltaT = System.currentTimeMillis() - millis;
		System.out.println(deltaT);
	}
	

}
