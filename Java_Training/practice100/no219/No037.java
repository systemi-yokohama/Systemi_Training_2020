package Java_Training.practice100.no219;
import java.time.LocalDate;
import java.util.Arrays;
public class No037 {
	public static void main(String[] args) {
		var list1=new StringBuilder[]{
			new StringBuilder(LocalDate(2020,3,15));
			new StringBuilder(LocalDate(2020,4,15));
			new StringBuilder(LocalDate(2020,5,15));
		};
		var list2 =Arrays.copyOf(list1, list1.length);
		list1[2].append(",100");
		System.out.println(Arrays.toString(list1));
		System.out.println(Arrays.toString(list2));
	}
}
