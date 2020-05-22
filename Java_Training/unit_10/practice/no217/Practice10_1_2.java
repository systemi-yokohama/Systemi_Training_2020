package Java_Training.unit_10.practice.no217;

import java.util.ArrayList;
// import java.util.Arrays;

public class Practice10_1_2 {
	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<String>();

		animals.add("cat");
		animals.add("dog");
		animals.add("monkey");

		System.out.println(animals);
		
		animals.removeIf(v -> v.length() < 5);
		System.out.println(animals);
		
	}
}