package Java_Training.practice100.no216;
import java.time.LocalDateTime;
import java.time.SimpleDateFormat;

public class No047 {
	public static void main(String[] args) {
		var dt = LocalDateTime.now();

		public static void FormatUtil() {
			System.out.println(dt.format(DateTimeFormatter.ofpattern(yyyy-M-dd kk:mm:ss.SSS)));
		}
	}
}