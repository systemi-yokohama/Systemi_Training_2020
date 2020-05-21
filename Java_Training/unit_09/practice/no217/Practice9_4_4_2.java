package Java_Training.unit_09.practice.no217;

public class Practice9_4_4_2 {
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
			var day = Weekday.valueOf("Monday");
			System.out.println(day instanceof Weekday);
	}
}