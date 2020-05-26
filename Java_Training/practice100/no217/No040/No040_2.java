package Java_Training.practice100.no217.No040;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class No040_2 implements UncaughtExceptionHandler{
	
	// キャッチされなかった例外を取得し、トレース情報と現在時刻を標準出力して、強制終了
	public void uncaughtException(Thread thread, Throwable throwable) {
	//アプリケーションの終了
	System.out.println("例外が発生しました。\n");
        
	/* 現在時刻の取得 */
	String time = nowTime();
	
	/* 現在時刻を標準エラー出力 */
	System.err.println(time);
	
	/* エラーのトレース情報を出力 */
	throwable.printStackTrace();
	
	/* 強制終了 */
	System.exit(1);
	}

	// 現在事項句を返すメソッド
	public String nowTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        
        return df.format(calendar.getTime());
    }
}