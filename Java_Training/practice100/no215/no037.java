package Java_Training.practice100.no215;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class no037 {
	public static void main(String[] args){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		var list1=new ArrayList<Date>(Arrays.asList("2010/01/01","2020/01/01"));
		

		/*ArrayList<Date> list1 = new ArrayList<>();
		("2010/01/01");
		*/


		final ArrayList<Date> list2 = list1;
	}
}