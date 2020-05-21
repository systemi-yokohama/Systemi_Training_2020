package Java_Training.unit_10.practice.no210.Practice10_3;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Practice10_3_345 {
	public static void main(String[] args) {
		//3
		var list = new ArrayList<String>(Arrays.asList("ABCD", "OP", "WXYZ", "HIJKL"));
		list.replaceAll(v -> {if(v.length() >= 3) {
			return v.substring(0, 3);
		} else {
			return v;
		}});

		//4
		Stream.of("シュークリーム", "プリン", "マドレーヌ", "ババロア")
		.sorted((str1, str2) -> str2.length() - str1.length())
		.forEach(System.out::println);

		//5
		var points = new int[] {60, 95, 75, 80, 70};
		System.out.println(IntStream.of(points).max().orElse(0));
		System.out.println(IntStream.of(points).average().orElse(0));
	}

}