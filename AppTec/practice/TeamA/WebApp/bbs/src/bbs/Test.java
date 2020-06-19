package bbs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date dt2 = new Date();
		Date dt = new Date();

		Calendar d2 = Calendar.getInstance();





		d2.setTime(dt2);
		d2.add(Calendar.DAY_OF_MONTH, -1);

		Date date2 = d2.getTime();


  		System.out.println(sdf.format(date2));
  		System.out.println(sdf.format(dt));



//  		Calendar calendar = Calendar.getInstance();
//  		calendar.set(Calendar.DAY_OF_MONTH, 31);//日を設定
//  		Date date = calendar.getTime();
//
//  		System.out.println(sdf.format(date)); // => Mon Dec 31 13:01:05 JST 2018
//  		System.out.println(sdf.format(calendar));
	}
}
