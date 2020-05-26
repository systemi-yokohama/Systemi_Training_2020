package Java_Training.practice100.no210.no040;
import java.time.LocalTime;

public class No040 implements Runnable {

	public static void main(String[] args) {
		try {
			var thr = new Thread(new No040());
			System.out.println(thr);
		} catch(Exception e) {
			System.out.println(e + " 現在時刻：" + LocalTime.now());
		}
	}

	public void run() {

	}
}