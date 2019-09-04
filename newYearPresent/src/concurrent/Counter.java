package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Counter {
	
	private static int countA = 0;
	private static int countB = 0;

	public static void main(String[] args) {
		
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		
		Runnable task = new Runnable() {
			public synchronized void run() {
				//Thread current = Thread.currentThread();
				for(int i = 0; i <= 10; i++) {
				System.out.println(countA + " : " + countB);
				countA = countA + 1;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countB = countB + 1;
				}
			}
		};
		
		Thread th = new Thread(task);
		th.start();
		Thread th1 = new Thread(task);
		th1.start();
	}

}
