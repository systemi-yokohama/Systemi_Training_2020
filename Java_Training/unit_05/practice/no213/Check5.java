/* [1] */
package Java_Training.unit_05.practice.no213;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Check5 {
	public static void main(String[] args) {
		var str = "となりのかきゃくはよくかきくうきゃくだ";
		var chi = "彼女の名前は花子です。";
		System.out.println(str.lastIndexOf("きゃく"));
		System.out.println(String.format("%sの気温は%.2f℃です。", "千葉", 17.256));
		System.out.println(chi.replaceAll("彼女", "妻"));
		var date = LocalDateTime.now();
		var duration = Duration.parse("P5DT6H");
		System.out.println(date.plus(duration));
		var dt1 = LocalDateTime.of(2020, 03, 12);
		var dt2 = LocalDateTime.of(2020, 11, 05);
		var period = Period.between(dt1.toLocalDate(), dt2.tLocalDate());
		System.out.println(period.getMonths() + "ヵ月" + period.getDays() + "日間");
	}
}

/* [2] 
	①java.util.regex.Pattern
	②try
	③Paths.get
	④readline()
	⑤matcher
	⑥line
	⑦group()*/



public class DateWrite () {
	public static void main(String[] args) {
	try(var writer = Files.newBufferedWriter(Paths.get("C:\\data\\data\\data.dat"),
	StandardOpenOption.APPEND)) {
		Charset.forName("Windows-31J");
	}
}

public class keisan () {
	public static void main(String[] args) {
		System.out.println(Math.pow(6, 3));
		System.out.println(Math.abs(-15));
		var array = new int[] {110, 14, 28, 32};
		System.out.println(Arrays.sort(array));
	}
}