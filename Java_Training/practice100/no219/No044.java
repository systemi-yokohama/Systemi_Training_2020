package Java_Training.practice100.no219;
import java.util.ArrayList;
import java.util.Arrays;
public class No044 {
	public static void main(String[] args) {
		var list = new ArrayList<String>(Arrays.asList(
			"",
			"",
			"",
			"",
			""
		));

		list.sort((x, y) -> x.length() - y.length());
		System.out.println(list);
	}
}
