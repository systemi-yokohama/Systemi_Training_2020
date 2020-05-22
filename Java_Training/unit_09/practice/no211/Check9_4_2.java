package Java_Training.unit_09.practice.no211;

public class Check9_4_2 {
	public enum Weekday{
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday
	}
 
	public boolean check(Object obj) {
		return obj instsnceof Weekday;
	}
}