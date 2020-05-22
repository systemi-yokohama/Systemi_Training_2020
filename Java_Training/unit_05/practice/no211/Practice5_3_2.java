package Java_Training.unit_05.practice.no211;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Practice5_3_2 {
	public static void main(String[] args) {
		var date = LocalDateTime.now();
		var date20 = date.plus(20, ChronoUnit.DAYS);

		System.out.println("20日後は" + date20);
	}
}

//→おそらく〇