package Java_Training.practice100.no214;
//	以下は、マルチスレッドプログラミングの一部である。問題点を指摘し、修正せよ。
public class No071 {
		private static long longValue = 0;
		public static void main(String[] args) throws Exception {
			final int LOOP = 1000 * 1000;
	
			// スレッド1で値をaddする
			Thread th1 = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < LOOP; i++) {
						longValue++;
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}				
							
					}
				}
			});
	
			// スレッド2でも値をaddする
			Thread th2 = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < LOOP; i++) {
						longValue++;
				
						}		}
			});
		
			th1.start();
			th2.start();
	
			// 2つのスレッドが止まるまでまつ
			th1.join();
			th2.join();
	
			System.out.println("Finished:" +  longValue);
		}
	}	
//問題点…スレッドが同時処理中に切り替わるタイミングがないこと