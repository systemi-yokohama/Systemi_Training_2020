package Java_Training.practice100.no210.no047;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.text.SimpleDateFormat;
import java.util.Date;

public class No047 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("y-MM-dd HH:mm:ss.SSS");
		
		var input = new Date();
		var date = sdf.parse(input.toString());
	
		System.out.println(date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
	}
}