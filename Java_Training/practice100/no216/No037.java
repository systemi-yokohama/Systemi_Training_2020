package Java_Training.practice100.no216;
import java.util.Arrays;
import java.time.LocalDate;

public class No037 {
	public static void main(String[] args) {
		var list1 = new LocalDate[];
		var list2 = Arrays.copyOf(list1, list1.length);

		var list3 = new localDate[list1.length];
		for (var i = 0; i < list1.length; i++) {
			list3[i] = new LocalDate(list1[i].toLocalDate());
		}
	}
}