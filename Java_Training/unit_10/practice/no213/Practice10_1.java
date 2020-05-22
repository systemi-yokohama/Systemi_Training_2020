/* i -> i * i; */



package Java_Training.unit_10.practice.no213;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice10_1 {
	public static void main(String[] args) {
		var list = new ArrayList<String>(
			Arrays.asList("蝋燭", "LEDライト", "蛍光灯")
		);
		list.removeIf(v -> v.length() < 4);
		System.out.println(list);
	}
}