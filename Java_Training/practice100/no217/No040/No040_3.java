package Java_Training.practice100.no217.No040;
// サブスレッド実行クラス
public class No040_3 implements Runnable {
	// サブスレッド実行
	public void run() {
        // ArithmeticExceptionを発生させる.
        int tmp = 2/0;
    }
}