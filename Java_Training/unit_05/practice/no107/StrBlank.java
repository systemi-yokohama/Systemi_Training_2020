package Java_Training.unit_05.practice.no107;

public class StrBlank {

	public static void main(String[] args) {

		var str1 = "";
		var str2 = " 　  ";

		System.out.println(str1.isEmpty());
		System.out.println(str1.isBlank());

		System.out.println(str2.isEmpty());
		System.out.println(str2.isBlank());
	}

}