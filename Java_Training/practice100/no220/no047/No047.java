package Java_Training.practice100.no220.no047;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No047 {

	public static void main(String[] args) {
		
			var datetime = new Date();
			if(datetime == null) {
				System.out.println("null");
			} else {
				SimpleDateFormat sdformat = new SimpleDateFormat("yyyy年-MM月-dd日 HH時:mm分:ss秒.SSS");
				System.out.println(sdformat.format(datetime));
			}
	

			// String strDate = "2020年-05月-17日 00時:00分:00秒.000";
			// if(strDate == null) {
			// 	System.out.println("null");
			// } else {
			// 	var dtf = DateTimeFormatter.ofPattern("yyyy年-MM月-dd日 HH時:mm分:ss秒.SSS");
			// 	var ldtime = LocalDateTime.parse(strDate, dtf);

			// 	System.out.println(ldtime.format(dtf).toString());
			// }
		}
	
}