package Java_Training.practice100.no107.no044;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class No044 implements Comparable {

	public static void main(String[] args) {
		Date d1 = new Date();
		Date d2 = new Date(1476423938529L);
		Date d3 = new Date(1421453545000L);

		List dList = new ArrayList<Date>();

		dList.add(d3);
		dList.add(d1);
		dList.add(d2);

		System.out.println("ソート前：");
		System.out.println(dList);

		Collections.sort(dList);

		System.out.println("ソート後：");
		System.out.println(dList);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub

		return 0;
	}

}