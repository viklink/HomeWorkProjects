package concurrent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable {
	private Writer text;
	
	public Reader(Writer w) {
		this.text = w;
	}

	@Override
	public void run() {
		Thread current = Thread.currentThread();
		synchronized (text) {
			try {
				
				BufferedReader br = new BufferedReader(new FileReader("myFile.txt"));
				String s;
			    while((s=br.readLine())!=null){
				System.out.print(s + " ");
				}
			    System.out.println(Thread.currentThread().getName());
				text.wait();
				
			} catch(InterruptedException e) {
				 System.out.println(e.getMessage());
			} catch(IOException e){
				System.out.println(e.getMessage());
			} 
		}
	}
	
	

}
