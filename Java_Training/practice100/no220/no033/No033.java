package Java_Training.practice100.no220.no033;
import java.util.*;

public class No033 {
	public static void main(String[] args){
		
	final List<Integer> numlist = new ArrayList<>
	(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

	numlist.stream().filter(i -> i % 2 == 1).forEach(System.out::println);
	}
	
	
}