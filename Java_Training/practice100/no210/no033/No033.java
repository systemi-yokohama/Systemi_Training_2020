package Java_Training.practice100.no210.no033;
import java.util.Arrays;
import java.util.ArrayList;

public class No033 {
	public static void main(String[] args) {
		var list = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

		list.stream().filter(i -> i % 2 == 1).forEach(System.out::println);
	}

	
}