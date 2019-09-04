package concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Spam extends Thread {

	private static int[] timeInt;
	private static String[] message;

	public Spam(int[] timeInt, String[] message) {
		if (timeInt.length != message.length) {
			throw new IllegalArgumentException("Массив интервалов времени и массив сообщений не согласованы");
		}

		this.timeInt = timeInt;
		this.message = message;
		start();
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < timeInt.length; i++) {
				Thread.sleep(timeInt[i]);
				System.out.println(message[i]);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static class Listener extends Thread {
		Thread thread;
		public static final InputStream inSt = System.in;

		public Listener(Thread thread) {
			super();
			setDaemon(true);
			this.thread = thread;
			start();

		}

		@Override
		public void run() {
			try {
				char ch;
				while (!thread.isInterrupted()) {
					ch = (char) inSt.read();
					if (ch == '\n') {
						thread.interrupt();
					}
				}
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		int[] timeInt = { 1000, 1000, 1000, 2000, 2000 };
		String[] message = { "Message1", "Message2", "Message3", "Message4", "Message5" };
		Thread spamThread = new Spam(timeInt, message);
		Thread listenThread = new Listener(spamThread);

	}
}
