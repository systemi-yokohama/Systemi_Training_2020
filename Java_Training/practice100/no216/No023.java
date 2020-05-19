package Java_Training.practice100.no216;

public class No023 {
	public static void main(String[] args) {
		String  a = msg(1);
		String  b = msg(1);
		System.out.println(a + "," + b);
	}

	static String msg(int a) {
		return String.valueOf(a);
	}

	static String msg(float b) {
		return String.valueOf(b);
	}
}