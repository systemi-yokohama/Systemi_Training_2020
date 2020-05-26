package Java_Training.unit_11.practice.no217;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Practice11_1_2 {
	public static void main(String[] args) {
		var sche = Executors.newScheduledThreadPool(2);
		sche.scheduleAtFixedRate(() -> {
			System.out.println(LocalDateTime.now());
		},0,5,TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		sche.shutdown();
	}
}