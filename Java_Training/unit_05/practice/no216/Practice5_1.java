package Java_Training.unit_05.practice.no216;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;

public class Practice5_1 {
	public static void main(String[] args) {
		//1
		var str = "となりのきゃくはよくきゃくくうきゃくだ";
		System.out.println(str.indexOf("きゃく",3));

		//2
		System.out.println(String.format(
			"%sの気温は%.2f℃です。", "千葉", 17.256
		));

		//3
		var str3 = "彼女の名前は花子です";
		System.out.println(str3.replaceAll(
			"彼女", "妻"
		));

		//4
		var dt = LocalDateTime.now();
		var duration = Duration.parse("P2DT6H");
		System.out.println(dt.minus(duration));

		//5
		var date1 = LocalDateTime.of(2020, 3, 12, 0, 0, 0);
		var date2 = LocalDateTime.of(2020, 11, 05, 0, 0, 0);
		var period = Period.between(date1.toLocalDate(), date2.toLocalDate());

		System.out.println(period.getMonths() + "ヵ月" + period.getDays() + "日間");
	}
}