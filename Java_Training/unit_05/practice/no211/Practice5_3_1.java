package Java_Training.unit_05.practice.no211;
import java.time.LocalDateTime;

public class Practice5_3_1 {
	public static void main(String[] args) {
		var date = LocalDateTime.now();

		var month = date.getMonth();
		var minute = date.getMinute();

		System.out.println("month:" + month + "   minute:" + minute);
	}
}

//→〇