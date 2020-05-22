package Java_Training.practice100.no220.no047;
import java.util.Date;
import java.text.SimpleDateFormat;

public class No047 {

	public static void main(String[] args) {
		
			var datetime = new Date();
			if(datetime.equals(null)) {
				System.out.println("null");
			} else {
				SimpleDateFormat sdformat = new SimpleDateFormat("yyyy年-MM月-dd日 HH時:mm分:ss秒.SSS");
				System.out.println(sdformat.format(datetime));
			}
		
	}
}