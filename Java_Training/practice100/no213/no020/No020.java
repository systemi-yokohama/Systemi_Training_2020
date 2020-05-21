package Java_Training.practice100.no213.no020;

import java.util.ArrayList;
import java.util.List;

public class No020 {
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};
	public static void main(final String[] args) {
		final List<String> list = new ArrayList<String>();
		for(var list : MEDALS) {
			list.add("NO MEDAL");
		}

		final List list1 = new ArrayList();
		for(var list1 : MEDALS) {
			list1.add("No Medal");
		}

		for(int i = 0; i < MEDALS.length; i++) {
			System.out.println(MEDALS.get(i));
		}

	}
}