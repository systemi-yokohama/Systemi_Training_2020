package Java_Training.unit_05.practice.no211;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.Period;

public class Check5_1 {
	public static void main(String[] args) {
		//1
		var str1 = "となりのきゃくはよくかきくうきゃくだ";
		System.out.println(str1.lastIndexOf("きゃく"));

		//2
		System.out.printf("%sの気温は%.2f℃です。\n","千葉",17.256);

		//3
		var str3 = "彼女の名前は花子です。";
		System.out.println(str3.replaceAll("彼女","妻"));
		//Allはなくても可

		//4
		var date4 = LocalDateTime.now();
		System.out.println(date4.plus(126,ChronoUnit.HOURS));

		//5
		var date5_1 = LocalDateTime.of(2020, 3, 12, 0, 0, 0);
		var date5_2 = LocalDateTime.of(2020, 11, 5, 0, 0, 0);

		var date5 = Period.between(date5_1.toLocalDate(), date5_2.toLocalDate());

		System.out.println(date5.getMonths()+"ヵ月"+date5.getDays()+"日間");
	}
}