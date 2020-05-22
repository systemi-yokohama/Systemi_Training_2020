/* [1]
	×
	×
	×
	×
	×

   [2]
	①<T>
	②Predicate<T>
	③cond.test(value)
	④result.add(value)
	⑤v -> v.length() > 3*/

package Java_Training.unit_10.practice.no213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Check10 {
	public interface Hoge {
		void print(String str);
	}

	public interface Foo<T, R> {
		R process(T v1, T v2);
	}

	public static void main(String[] args) {
		var list = new ArrayList<String>(
			Arrays.asList("ABCDE", "OP", "WXYZ", "HIJK")
		);
		list.replaceAll(v -> {
			if(v.length() < 3){
				return v;
			} else {
				return v.substring(0, 3);
			}
		});
		System.out.println(list);

		Stream.of("シュークリーム", "プリン", "マドレーヌ", "ババロア")
		.sorted((str1, str2) -> str2.length() - str1.length())
		.forEach(System.out::println);

		var list1 = new int[] {
			60, 95, 75, 80, 70
		};
		System.out.println(IntStream.of(list1).max().orElse(0));
		System.out.println(IntStream.of(list1).average().orElse(0));

	}
}