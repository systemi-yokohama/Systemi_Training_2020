package Java_Training.practice100.no220.no044;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class No044_3 {

	public String cldate2() {
 		Calendar cl = Calendar.getInstance();
		cl.set(2019,5,15,9,15,8);
		var getcl = cl.getTime();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分 ss秒");
		
		return sdformat.format(getcl);
	}
}
