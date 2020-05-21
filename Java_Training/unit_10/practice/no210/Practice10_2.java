package Java_Training.unit_10.practice.no210;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Practice10_2 {
	public static <T> List<T> grep(List<T> list, Predicate<T> cond) {
		var result = new ArrayList<T>();
		for(var value : list) {
			if(cond.test(value)) {
				return result.add(value);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		var data = List.of("ラベンダー", "ミント", "ローズマリー");
		//3文字より長い文字列だけを抽出
		var result = grep(data, d -> d.length() > 3);
		System.out.println(result);
	}
}