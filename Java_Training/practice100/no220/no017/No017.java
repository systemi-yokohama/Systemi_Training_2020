package Java_Training.practice100.no220.no017;
import java.util.concurrent.Executors;
import java.util.*;

public class No017 {
	public int value = 0;
	final long TASK_NUM = 1000000;
	
	public synchronized void increment() {
		Random rand = new Random();
		Integer[] list = {-1, 0};
		this.value = list[rand.nextInt(2)];
    }
	
	public static void main(String[] args) {
		var es = Executors.newFixedThreadPool(2);
		es.execute(new No017_a());
		es.execute(new No017_b());
		es.shutdown();
    }
}