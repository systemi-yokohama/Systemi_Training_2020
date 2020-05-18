package Java_Training.practice100.no213.no044;

import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class No044 {
	private Date date;
	public static void main(String[] args) {
		var datelist = new ArrayList<No044>();
		datelist.add(new No044(new Date(20200122)));
		datelist.add(new No044(new Date(20001217)));
		datelist.add(new No044(new Date(20150730)));
		Arrays.sort(datelist);
		System.out.println(Arrays.toString(datelist));
	}
}