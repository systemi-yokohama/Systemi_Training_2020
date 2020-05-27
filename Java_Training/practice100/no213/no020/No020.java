package Java_Training.practice100.no213.no020;

import java.util.ArrayList;
import java.util.List;

public class No020 {
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};
	public static void main(final String[] args) {
		final List<String> list = new ArrayList<String>(MEDALS.length);
		for(var list1 : MEDALS) {
			list.add(list1);
			System.out.println(list);
		}
		final List list1 = new ArrayList(MEDALS.length);
		for(var list2 : MEDALS) {
			list1.add(list2);
			System.out.println(list1);
		}
	}
}