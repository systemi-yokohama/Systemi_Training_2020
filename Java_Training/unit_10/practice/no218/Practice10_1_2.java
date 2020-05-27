package Java_Training.unit_10.practice.no218;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice10_1_2 {
	public static void main(String[] args){
		var list = new ArrayList<String>(
			Arrays.asList("aaaaa","bb","cccccc")
		);

		list.removeIf(v -> v.length() < 5);
		System.out.println(list);
	}
	
}