package Java_Training.unit_09.practice.no107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Practice9_2 {

	public static void main(String[] args) {

		// elements
		String[] list = { "a", "b", "c" };

		// collection
		List<String> TList = new ArrayList<String>();
		List<String> EList = new ArrayList<String>();

		// TListへの処理
		var result = Collections.addAll(TList, list);

		System.out.println(result);

		System.out.println(TList + "TList");

		for (int i = 0; i < TList.size(); i++) {
			System.out.println(i + "番目の要素: " + TList.get(i));
		}

		// EListへの処理
		EList.addAll(Arrays.asList("5", "6", "7", "8"));

		// 違い
		Collections.addAll(new ArrayList<String>(), list);
		new ArrayList<String>().addAll(Arrays.asList("5", "6", "7", "8"));

		for (int j = 0; j < TList.size(); j++) {
			System.out.println(j + "番目の要素: " + EList.get(j));
		}

	}

}