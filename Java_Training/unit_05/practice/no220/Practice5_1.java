package Java_Training.unit_05.practice.no220;
import java.time.LocalDateTime;
import java.time.Period;

public class Practice5_1 {
	public static void main(String[] args) {

		// 問1
		String str1 = "となりのきゃくはよくきゃくくうきゃくだ";
		System.out.println(str1.lastIndexOf("きゃく"));

		// 問2
		System.out.println(String.format("%sの気温は%.2f℃です", "千葉", 17.256));

		// 問3
		String str2 = "彼女の名前は花子です";
		System.out.println(str2.replace("彼女", "妻"));

		// 問4
		var date1 = LocalDateTime.now();
		date1 = date1.plusDays(5);
		System.out.println(date1.plusHours(6));
		
		// 問5
		var date2 = LocalDateTime.of(2020, 3, 12, 0, 0, 0);
		var date3 = LocalDateTime.of(2020, 11, 5, 0, 0, 0);
		
		var period = Period.between(date2.toLocalDate(), date3.toLocalDate());
		System.out.println("日付の差：" + period.getMonths() + "ヶ月" + period.getDays() + "日間");
	}

}