package Java_Training.practice100.no220.no044;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class No044_2 {

		public String cldate1() {
		Calendar cl = Calendar.getInstance();
		cl.set(2020,3,7,11,10,59);
		var getcl = cl.getTime();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分 ss秒");

		return sdformat.format(getcl);
		}
}
