package Java_Training.practice100.no218.no33;

import java.util.List;

public class No33 {

	public static void maiin(String[] args){
		List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6 , 7, 8, 9);
		numbers.stream()
		  .filter(number -> number % 2 == 1)
		  .forEach(System.out::println);
		System.out.println(numbers);
		  
	}

	
}