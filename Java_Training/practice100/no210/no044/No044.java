package Java_Training.practice100.no210.no044;
import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.SimpleDateFormat;

public class No044 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("yyyy/mm/dd");
		
		var date1 = new Date();	
		var date2 = sdf.parse("2019/05/01");
		var date3 = sdf.parse("2018/05/01");

		var list = new ArrayList<Date>(Arrays.asList(date1, date2, date3));
		Collections.sort(list);
	}
}