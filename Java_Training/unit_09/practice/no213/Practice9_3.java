package Java_Training.unit_09.practice.no213;

public class Practice9_3 {
	public enum Weekday {
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY,
	}
	public static void main(String[] args) {
		for(var week: Weekday.values()) {
			System.out.println(week.ordinal() + ":" + week.toString());
		}
	}
}