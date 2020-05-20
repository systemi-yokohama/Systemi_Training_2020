package Java_Training.unit_05.practice.no107;

public class StrStrip {
	public static void main(String[] args) {

		var str = "  Wings Project  ";
		var strTrim = "  t r m ";

		System.out.println(str.strip());
		System.out.println(str.stripLeading());
		System.out.println(str.stripTrailing());

		System.out.println(strTrim.trim());

	}
}