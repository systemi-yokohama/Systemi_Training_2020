package Java_Training.unit_10.practice.no219;

import java.util.Arrays;

import java.util.ArrayList;

public class Practice10_1_2 {
	public static void main(String[] args) {
		var list = new ArrayList<String>(
			Arrays.asList("バラ","チューリップ","あさがお","ヒヤシンス")
		);
		list.removeIf(v -> v.length() <5);
		System.out.println(list);
	}
}