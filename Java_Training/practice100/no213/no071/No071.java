/* th1とth2が同じ処理内容で同時進行している */

package Java_Training.practice100.no213.no071;

public class No071 {
	private static long longValue = 0;
	public static void main(String[] args) throws Exception {
		final int LOOP = 1000 * 1000;

		Thread th1 = new Thread(new Runnable(){
		
			@Override
			public void run() {
				for(int i = 0; i < LOOP; i++) {
					//同期処理
				}
			}
		});

		Thread th2 = new Thread(new Runnable(){
		
			@Override
			public void run() {
				//同期処理
			}
		});

		th1.start();
		th2.start();

		th1.join();
		th2.join();

		System.out.println("Finished" + longValue);
	}
}