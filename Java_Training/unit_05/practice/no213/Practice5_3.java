package Java_Training.unit_05.practice.no213;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoField;

public class Practice5_3 {
	public static void main(String[] args) {
		var date = LocalDateTime.now();
		System.out.println(date.get(ChronoField.MONTH_OF_YEAR) + "月\n" + date.get(ChronoField.MINUTE_OF_HOUR) + "分");
		var period = Period.ofDays(20);
		System.out.println(date.plus(period));
	}
}