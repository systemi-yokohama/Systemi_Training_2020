package Java_Training.practice100.no217.No040;

// キャッチされない例外のスタックトレースを現在時刻とともに標準エラー出力する.
public class No040_1 implements Runnable {
	public static void main(final String[] args) {
        Thread thread = new Thread(new No040_1());
        
        // No040_2を実装したハンドラをsetUncaughtExceptionメソッドで登録.
        thread.setUncaughtExceptionHandler(new No040_2());
        
        // メインスレッドの実行.
        thread.start();
	}	
	
	// スレッドの実行
	public void run() {
        // スリープ.
        try {
             Thread.sleep(500L);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        
        Thread No040_3 = new Thread(new No040_3());
        
        // UncaughtExceptionHandlerを実装したハンドラをサブスレッドに紐付ける.
        No040_3.setUncaughtExceptionHandler(new No040_2());
        
        // サブスレッドの実行.
        No040_3.start();
    }
}