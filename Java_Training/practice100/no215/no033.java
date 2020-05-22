package Java_Training.practice100.no215;

import java.util.ArrayList;
import java.util.Arrays;

public class no033 {
	public static void main(String[] args) {


		var list=new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		list.
		stream().
		filter(i -> !(i % 2==0)).
		forEach(System.out::println);
		
	}
}