package Java_Training.unit_09.practice.no211;

public class Practice9_3 {
	public enum Weekday{
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday
	}

	public static void main(String[] args) {
		for(var week : Weekday.values()){
			System.out.println(week.ordinal() + ":" + week.toString());
		}
	}
}