package Java_Training.practice100.no217;

public class No071 {
    private volatile static long longValue = 0;

    public static void main(String[] args) throws Exception {
        final int LOOP = 1000 * 1000;
        
        // スレッド1で値をaddする
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < LOOP; i++) {
                    // 同期処理.
                    increment();
                }
            }
        });

        // スレッド2でも値をaddする
        Thread th2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < LOOP; i++) {
                    // 同期処理.
                    increment();
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
    
    // インクリメントの同期処理用メソッド.
    private synchronized static void increment() {
        longValue++;
    }
}
