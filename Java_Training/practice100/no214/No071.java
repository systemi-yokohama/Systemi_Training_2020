package Java_Training.practice100.no214;

public class No071  {
    private static long longValue = 0;
    public static void main(String[] args) throws Exception {
        final int LOOP = 1000 * 1000;
        // スレッド1で値をaddする
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < LOOP; i++) {
					longValue++;
					try{
						Thread.sleep(100);
					  }catch(InterruptedException e){
                }
            }
		}
	}
		);
        // スレッド2でも値をaddする
        Thread th2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < LOOP; i++) {
					longValue++;
					try{
						Thread.sleep(300);
					  }catch(InterruptedException e){
                }
            }
		}
		});
        th1.start();
        th2.start();
        // 2つのスレッドが止まるまでまつ
        th1.join();
        th2.join();
        System.out.println("Finished:" +  longValue);
    }
}

//同時処理の過程で切り替わるタイミングがない