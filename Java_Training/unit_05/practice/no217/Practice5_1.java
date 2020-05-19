package Java_Training.unit_05.practice.no217;

public class Practice5_1 {
	public static void main(String[] args){
		// 1.substringメソッド
		String str1 = "プログラミング言語";
		System.out.println(str1.substring(4,7));

		// 2.splitメソッド		
		String str2 = "鈴木\t太郎\t男\t50歳\t広島県";
		String[] count1 = str2.split("\t");
			System.out.println(String.join("&",count1));
	}
}