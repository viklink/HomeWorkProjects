package concurrent;

public class ReadWriteTest {
	
	private static int[] timeInt;

	public static void main(String[] args) throws InterruptedException {
		
		int[] timeInt = {1000, 1000, 1000};
		
		for (int i = 0; i < timeInt.length; i++) {
		Writer writer = new Writer();
		writer.getText();

		Reader reader1 = new Reader(writer);
		Thread th1 = new Thread(reader1, "READER 1");
		th1.start();

		Reader reader2 = new Reader(writer);
		Thread th2 = new Thread(reader2, "READER 2");
		th2.start();

		Reader reader3 = new Reader(writer);
		Thread th3 = new Thread(reader3, "READER 3");
		th3.start();

		Notifier notifier = new Notifier(writer);
		new Thread(notifier, "NOTIFIER").start();
		
		Thread.currentThread().sleep(timeInt[i]);
		}
	}
}
