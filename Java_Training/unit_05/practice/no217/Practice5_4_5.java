package Java_Training.unit_05.practice.no217;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Practice5_4_5 {
	public static void main(String[] args){
		LocalDate date1 = LocalDate.of(2020,03,12);	
		LocalDate date2 = LocalDate.of(2020,11,05);	
		
		DateTimeFormatter format1 = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fdate1 = format1.format(date1);
		DateTimeFormatter format2 = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fdate2 = format2.format(date2);

		long months = ChronoUnit.MONTHS.between(date1, date2);
		long day = ChronoUnit.DAYS.between(date1, date2);

		System.out.println(months + "ヶ月" + day + "日間");
	}
}
