package Java_Training.practice100.no217;

import java.util.ArrayList;
// import java.util.List;

public class No033 {
	public static void main(String[] args) {

		// final List<Integer> numbers = Arrays.asList(
		// 	0,1,2,3,4,
		// 	5,6,7,8,9
		// );

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(0);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);

		numbers.stream().filter(i -> i % 2 == 1).forEach(System.out::println);
        }
	}
