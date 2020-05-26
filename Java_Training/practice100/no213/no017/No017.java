package Java_Training.practice100.no213.no017;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class No017 {
	private static volatile long long1 = -1L;
	public static void main(final String[] args) throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(2);
		final ExecutorService es = Executors.newFixedThreadPool(2);

		es.submit(() -> {
			for(int i = 0; i < 1000000; i++) {
				assert long1 == 0 || long1 == -1 :
				String.format("long1(%d)is not 0 or -1.", long1);
			}
			latch.countDown();
		});

		es.submit(() -> {
			for(int i = 0; i < 1000000; i++) {
				long1 = (long1 == 0) ? -1L : 0;
			}
			latch.countDown();
		});
		latch.await();
		es.shutdown();
	}
}