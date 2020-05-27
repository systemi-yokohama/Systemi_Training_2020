package Java_Training.practice100.no213.no040;

import java.time.LocalDateTime;

public class No040 {
	Thread thread = new Thread();
	public void uncaughtException(Thread thread, Throwable e) {
		try {
			thread.sleep(100);
		} catch (InterruptedException sa) {
			sa.printStackTrace();
			System.err.println("エラー");
			System.err.println(LocalDateTime.now());
		}
	}
}