package Java_Training.practice100.no211;
import java.time.LocalDateTime;

public class No047 {
	public class FormatUnit{

		public void form(int year,int month,int day,int hour,int minute,int second,int milli){
			var time = LocalDateTime.of(year, month, day, hour, minute, second, milli);
			if(time==null){
				System.out.println("null");
			}
			System.out.println(time);
		}

		/*
		→
		import java.util.Date;

		public class Answer047 {
    	public static void main(String[] arguments) {
        	// 現在時刻をフォーマットして表示
        	String dateStr = FormatUtil.dateToFormatString(new Date());
        	System.out.println(dateStr);
		}
		*/
	}
}