package Java_Training.practice100.no216;
import java.util.*;


public class No044 {
	public static void main(String[] args) {
		ArrayList<Date> list = new ArrayList<Date>();

		Collections.sort(list);

		for (Integer a : list) {
			System.out.println(a);
		}
	}
}