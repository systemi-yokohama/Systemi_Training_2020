package Java_Training.practice100.no220.no017;

class No017_a implements Runnable {
	No017 main = new No017();

	public void run() {
		for (int i = 0; i < main.TASK_NUM; i++) {
			try {
				Thread.sleep(1000);
				main.increment();
				System.out.println("A" + i + "：" + main.value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	
	}
}