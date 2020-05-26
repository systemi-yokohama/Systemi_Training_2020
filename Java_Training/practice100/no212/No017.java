/*
代入
・あるlong型の変数の参照を100万回するだけのスレッドAと、
その同じ変数を0か-1かどちらかを代入することを100万回繰り返すスレッドBを同時に動作させ、
スレッドAではこの変数の値を参照したときに必ず0または-1となるようにするプログラムを実装
*/

package Java_Training.practice100.no212;

public class No017 extends Thread {
	int count = 1000000;
	num = 0L;

public void run() {
	for (int i = 0; i < count; i++) {
		if (num.get() == 0L) {
			num.set(-1L);
		} else {
			num.set(0L);
		}
		System.out.print("A" + num);
	}
}

public static void main(String arguments[]) {
	No017 thread1 = new No017();
	thread1.start();

	for (int i = 0; i < count; i++) {
		System.out.print("B" + num.get());
	}
}
}