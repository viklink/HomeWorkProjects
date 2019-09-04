package concurrent;

public class GetThreadName {

	public static void main(String[] args) throws Exception {
		/*
		 * //Реализация интерфейса Runnable Thread t = new Thread(() ->
		 * System.out.println(Thread.currentThread().getName())); t.start();
		 * System.out.println(Thread.currentThread().getName());
		 */

		Runnable task = new Runnable() {
			public void run() {
				Thread current = Thread.currentThread();

				while (!current.isInterrupted()) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		};

		Thread th = new Thread(task);
		th.start();
		Thread.sleep(5000);
		th.interrupt();

		Thread th1 = new ThreadName();
		th1.start();
		Thread.sleep(5000);
		th1.interrupt();
	}

	// сделать при помощи расширения от класса Thread
	public static class ThreadName extends Thread {
		@Override
		public void run() {
			Thread current = Thread.currentThread();

			while (!current.isInterrupted()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
				System.out.println(Thread.currentThread().getName());
			}
		}
	}

}
