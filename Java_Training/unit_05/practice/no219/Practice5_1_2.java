package Java_Training.unit_05.practice.no219;

public class Practice5_1_2 {
	public static void main(String[] args) {
		var str ="鈴木¥t太郎¥t男¥t50歳¥t広島県";
		var result = str.split("¥t");
		System.out.println(String.join("&",result));
	}
}