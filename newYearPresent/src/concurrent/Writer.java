package concurrent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	private String text;

	public Writer() {
	}

	Runnable write = new Runnable() {
		public void run() {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"));
				String text = "Hello, World!";
				bw.write(text);
				bw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	};

	public String getText() {
		Thread t = new Thread(write);
		t.start();
		return text;
	}

	public void setText(String str) {
	}
}
