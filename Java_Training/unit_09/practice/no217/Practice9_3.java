package Java_Training.unit_09.practice.no217;

public class Practice9_3 {
	/*1.月曜から日曜をメンバーとして持つ列挙型Weekdayを定義
	  2.「インデックス番号：名前」で出力*/
	public enum Weekday {
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday,
	}
	public static void main(String[] args) {
		for(Weekday day : Weekday.values()){
			System.out.println("[" + day.ordinal() + "]：" +  day.toString());
		}
	}
}