package Java_Training.practice100.no210.No017;
import java.util.concurrent.Executors;

public class No017 {
	private static long value = 0;

	public static void main(String[] args) {
		var thr = Executors.newFixedThreadPool(2);

		// スレッドA
		thr.submit(() -> {
			for(var i = 0; i < 1000000; i++) {
				if(value == 0 || value == -1) {
					System.out.println(value);
				}
			}
		});

		//スレッドB
		thr.submit(() -> {
			for(var i = 0; i < 1000000; i++) {
				if(value == 0) {
					value = -1;
				} else {
					value = 0;
				}
			}
		});

		thr.shutdown();
	}
	
}