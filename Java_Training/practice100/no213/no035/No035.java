package Java_Training.practice100.no213.no035;

public class No035 {
	public static void main(String[] args) {
		ThreadGroup group1 = new ThreadGroup("group1");
		ThreadGroup group2 = new ThreadGroup("group2");

		for(int i = 1; i < 100; i++) {
			new Thread(group1, "group1").start();
			new Thread(group2, "group2").start();
		}
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("group1:" + group1.activeCount());
				System.out.println("group2:" + group2.activeCount());
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}