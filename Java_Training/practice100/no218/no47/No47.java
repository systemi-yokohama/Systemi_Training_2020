package Java_Training.practice100.no218.no47;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class No47 {
	public static void main(final String[] args) {
		final Calendar c = Calendar.getInstance();

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:SSS");
		
		System.out.println(sdf.format(c.getTime()));
		



	}
	
}