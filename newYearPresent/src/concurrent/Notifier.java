package concurrent;

public class Notifier implements Runnable {

	private Writer text;

	public Notifier(Writer text) {
		this.text = text;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			synchronized (text) {

				text.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
