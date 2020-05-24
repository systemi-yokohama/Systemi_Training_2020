package Java_Training.unit_05.practice.no213;

public class Practice5_1 {
	public static void main(String[] args) {
		var str = "プログラミング言語";
		System.out.println(str.substring(4, 7));

		var str2 = "鈴木￥t太郎￥t男￥t50￥t広島県";
		var result = str2.split("￥");
		System.out.println("&", result);
		}
	}
}