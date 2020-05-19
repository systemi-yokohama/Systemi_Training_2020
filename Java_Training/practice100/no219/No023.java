package Java_Training.practice100.no219;

public class No023 {
	
	private static String convertString(final int a) {
		return String.valueOf(a);
	}
	private static String convertString(final float b) {
		return String.valueOf(b);
	}
	
	public static void main(final String[] args) {
        System.out.println(convertString(12));
        System.out.println(convertString(1.63f));
    }
}