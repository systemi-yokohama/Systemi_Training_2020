package Java_Training.practice100.no216;
import java.time.LocalDateTime;
import java.time.SimpleDateFormat;

public class No047 {
	public static void main(String[] args) {
		var d = new LocalDateTime.now();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd kk:mm:ss.SSS");

		System.out.println(sdf.format(d));
	}
}