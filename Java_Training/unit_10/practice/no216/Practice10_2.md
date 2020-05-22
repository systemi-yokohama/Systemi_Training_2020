package Java_Training.unit_10.practice.no216;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Practice10_2 {
	//1,2
	public static <T> List<T> grep(List<T> list, predicate<T> cond) {
		var result = new Arraylist<T>();
		for(var value : list) {
			//3
			if (cond.test(value)) {
				//4
				result.add(value);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		var data = List.of("ラベンダー", "ミント", "ローズマリー");
		//5
		var result = grep(data, v -> v.length() > 3);
		System.out.println(result);
	}
}
