package Java_Training.unit_05.practice.no219;
import java.time.LocalDate;
import java.time.Period;
public class Practice5_3_2 {
	public static void main(String[] args) {
		var data =LocalDate.now();
		var period =Period.ofDays(20);
		System.out.println("20日後は、"+data.plus(period));
	}
}