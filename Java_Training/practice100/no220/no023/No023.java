package Java_Training.practice100.no220.no023;

public class No023 {
	public static void main(String[] args) {

		System.out.println(method(100));
		System.out.println(method(100f));
	}

	public static String method(int i) {
		return	Integer.toString(i);
	}

	public static String method(float f) {
		return	Float.toString(f);
	}

}