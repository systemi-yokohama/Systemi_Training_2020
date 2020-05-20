package Java_Training.unit_05.practice.no107;

public class StrIndex {
	public static void main(String[] args) {
		var str = "にわにはにわにわとりがいる";

		System.out.println(str.indexOf("にわ"));
		System.out.println(str.indexOf("にも"));
		System.out.println(str.lastIndexOf("にわ"));
		System.out.println(str.indexOf("にわ", 3));
		System.out.println(str.lastIndexOf("にわ", 3));

	}
}