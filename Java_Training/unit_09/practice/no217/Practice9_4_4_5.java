package Java_Training.unit_09.practice.no217;

import java.util.ArrayList;
import java.util.List;

public class Practice9_4_4_5 {

	public static <T> ArrayList<T>newArrayList(T... data) {
		return new ArrayList<T>(List.of(data));
	}

	public static void main(String[] args) {
		//
	}
}