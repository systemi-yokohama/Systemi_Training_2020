package Java_Training.practice100.no213.no023;

public class No023 {
	public static String same(int i) {
		return String.valueOf(i);
	}

	public static String same(float f) {
		return String.valueOf(f);
	}
	public static void main(String[] args) {
		System.out.println(same(4f));
		System.out.println(same(55));
	}
}