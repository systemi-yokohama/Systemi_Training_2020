package Java_Training.unit_05.practice.no210;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;
import java.time.Duration;

public class Practice5_1 {
	public static void main(String[] args) {
		//1
		var str = "となりのきゃくはようくきゃくくうきゃくだ";
		System.out.println(str.lastIndexOf("きゃく"));

		//2
		System.out.println(String.format("%sの気温は%.2fです。", "千葉", 17.256));

		//3
		var name = "彼女の名前は花子です。";
		System.out.println(name.replace("彼女", "妻"));

		//4
		var now = LocalDateTime.now();
		System.out.println(now.plus(Duration.parse("P5DT6H")));

		//5
		var d1 = LocalDate.of(2020,3,12);
		var d2 = LocalDate.of(2020,11,5);
		var period = Period.between(d1, d2);
		System.out.println("日付の差：" + period.getMonths() + "ヶ月" + period.getDays() + "日間");
	}
}