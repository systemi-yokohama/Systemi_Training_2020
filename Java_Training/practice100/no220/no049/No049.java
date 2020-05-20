package Java_Training.practice100.no220.no049;
import java.util.*;
import java.text.*;

public class No049 {

	
	public static void main(String[] args) {

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
		
		var fdate = sdf.format(date);
		
		// 現在時刻
		System.out.println(fdate);

		// 一日前
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		var yesterday = sdf.format(calendar.getTime());
		System.out.println(yesterday);

		// 一日後
		calendar.add(Calendar.DAY_OF_MONTH, +2);
		var tommorow = sdf.format(calendar.getTime());
		System.out.println(tommorow);

		
		Random rand = new Random();
		rand.nextInt(Integer.parseInt(tommorow) + yesterday);

    }
	
}