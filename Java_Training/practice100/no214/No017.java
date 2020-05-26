package Java_Training.practice100.no214;

import java.util.Random;

/*unit 11 
あるlong型の変数の参照を100万回するだけのスレッドAと、
その同じ変数を0か-1かどちらかを代入することを100万回繰り返すスレッドBを同時に動作させ、
スレッドAではこの変数の値を参照したときに必ず0または-1となるようにするプログラムを実装せよ。 */
public class No017 extends Thread{
	
    public static void main(String[]args) {
		Random rand = new Random();
	    final long num = rand.nextInt(10000); 
		var thA = new Thread(){
		@Override
		public void run(){
			for (int i = 0; i < 1000000; i++){
			System.out.println(num);
		} {
            try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
                e.printStackTrace();
			}
		}}};

		var thB=new Thread(new Runnable(){
			@Override
			public void run() {
			for (int i = 0; i < 1000000; i++){
				Random rand = new Random();		
				long addNUm = rand.nextInt(2)-1; 
				num = Thread.currentThread.num() + addNUm;
			} {
				try {
					Thread.sleep(100);
					System.out.println();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					}	
					}
	 });
	 thA.start();
	 thB.start();
	}
}