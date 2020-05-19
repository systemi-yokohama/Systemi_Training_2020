package Java_Training.practice100.no213.no044;

import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;

public class No044 {
	public static void main(String[] args) {
		var datelist = new ArrayList<Date>();
		datelist.add(new Date(20201202));
		datelist.add(new Date(20010211));
		datelist.add(new Date(20120824));
		Collections.sort(datelist, Collections.reverseOrder());
		System.out.println(datelist);
	}
}