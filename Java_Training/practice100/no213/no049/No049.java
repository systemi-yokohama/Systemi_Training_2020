package Java_Training.practice100.no213.no049;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class No049 {
	public static void main(String[] args) {
			var t = LocalDateTime.now();
			var d = Date.from(t.toInstant(ZoneOffset.of("+09.00")));
			var cal = Calendar.getInstance();
			cal.setTime(d);
			if (t >= cal || t >= cal) {
				System.out.println(t);
			}
		}
	}
}