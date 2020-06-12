/*
1～5秒（ランダム）ウェイトするだけのスレッドを、スレッドグループA,Bの2つでそれぞれ100個動作させ、
1秒おきに各スレッドグループで何個のスレッドが動作しているかを出力するプログラムを実装せよ。
*/

public class No035 extends Thread {
	@Override
	public void run(){
		var ache = Executors.newScheduledThreadPool(100);

		sche.sheduleAtFixedRate(() -> {
			System.out.println(LocalDateTime.now());
		}, 0, 5, TimeUnit.SECONDS);

		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

		sche.shutdown();
	}

	public static void main(String[] args){
		No035.run();
	}
}