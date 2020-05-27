package Java_Training.practice100.no217;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class No017 {
	// ループ回数
	private static final int COUNT = 1000000;
	// long変数	
	private static volatile long variable = -1L;

	public static void main(final String[] args) throws InterruptedException {
		// 複数スレッドの終了を同期する仕組み
		final CountDownLatch latch = new CountDownLatch(2);
		final ExecutorService es = Executors.newFixedThreadPool(2);

		// スレッドA	
		es.submit(() -> {
			for(int i = 0; i < COUNT; i++) {
				assert variable == 0 || variable == -1
				: String.format("variable (%d) is not 0 or -1.",variable);
			}
			latch.countDown();
		});

		// スレッドB
		es.submit(() ->{
			for(int i = 0; i < COUNT; i++) {
				variable = (variable == 0) ? -1L : 0L;
			}
			latch.countDown();
		});
		// A,B両方の終了まで待機
		latch.await();
		es.shutdown();
	}
}