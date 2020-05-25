package Java_Training.practice100.no215;

/* あるlong型の変数の参照を100万回するだけのスレッドAと、
その同じ変数を0か-1かどちらかを代入することを100万回繰り返すスレッドBを同時に動作させ、
スレッドAではこの変数の値を参照したときに必ず0または-1となるようにするプログラムを実装せよ。*/

public class no017 {
	
	long trd=0;
	public static void main(String[] args){
		for(int i=0; i<1000000; i++){
			System.out.println(i);
		}
	}
}