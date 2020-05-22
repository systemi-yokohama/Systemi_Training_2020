package Java_Training.practice100.no220.no049;
import java.util.*;
import java.text.*;
import java.time.*;


public class No049 {

	
	public static void main(String[] args) {
		public static List<String> createDateList(int year, int month, int day, int count) {
			List<String> list = new ArrayList<>();
			
			for (int i = 0; i < count; i++) {
				long dayStart = LocalDate.of(year, month, day).getLong(ChronoField.EPOCH_DAY);
				long dayEnd   = LocalDate.now().getLong(ChronoField.EPOCH_DAY);
	
				LocalDate dateRandom;
				long dayPeriod;
				if (dayStart <= dayEnd) {
					dayPeriod = dayEnd - dayStart;
					dateRandom = LocalDate.now().minusDays(new Random().nextInt((int) dayPeriod));
				} else {
					dayPeriod = dayStart - dayEnd;
					dateRandom = LocalDate.now().plusDays(new Random().nextInt((int) dayPeriod));
				}
				
				if (i == count -1) {
					System.out.println("指定年月日の日数 : " + dayStart);
					System.out.println("現在年月日の日数 : " + dayEnd);	
					System.out.println("期間日数　 　　　: " + dayPeriod);
					System.out.println("作成年月日 　　　: " + dateRandom);
				}
				
				list.add(dateRandom.toString());
			}
			
			return list;
		}
			
		public static void main(String[] args) {
			createDateList8(1997, 1, 1, 100);
		}

	}
}
	