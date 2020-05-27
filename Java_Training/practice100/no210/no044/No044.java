package Java_Training.practice100.no210.no044;
import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class No044 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("yyyy/mm/dd");
		
		var list = new ArrayList<Date>();
		try {
			var date1 = new Date();	
			var date2 = sdf.parse("2019/05/01");
			var date3 = sdf.parse("2018/05/01");
		
			list.add(date1);
			list.add(date2);
			list.add(date3);
		} catch(ParseException e) {
			e.printStackTrace();
		}  

		Collections.sort(list);
	}
}