package Java_Training.practice100.no214;
import java.lang.ThreadGroup;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
/*スレッド・スレッドグループ
1～5秒（ランダム）ウェイトするだけのスレッドを、スレッドグループA,Bの2つでそれぞれ100個動作させ、
1秒おきに各スレッドグループで何個のスレッドが動作しているかを出力するプログラムを実装せよ。 */
public class No035 implements Runnable{
	 ThreadGroup groupA = new ThreadGroup("GroupA");
     ThreadGroup groupB = new ThreadGroup("GroupB");  
    @Override public void run() {
        for (int i = 0; i < 100; i++) {
			new Thread(groupA, new Thread()).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(groupB, new Thread()).start();
        }
	}
	public static void main(String[] args) throws InterruptedException {
	Thread thread = new Thread(new No035());
	thread.start();
	for (int i = 1 ;; i++) {
		printActiveCount(i);
		thread.sleep(1000L);
		
		}
	}
	
}
