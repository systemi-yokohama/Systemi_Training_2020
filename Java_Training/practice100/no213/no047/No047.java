package Java_Training.practice100.no213.no047;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class No047 {
	public static void main(String[] args) {
	var dt = LocalDateTime.now();
	System.out.println(
		dt.format(DateTimeFormatter.ofPattern("Y-M-d k:m:s.S"))
		);
	}
}