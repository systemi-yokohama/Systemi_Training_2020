package Java_Training.unit_10.practice.no210;
import java.util.ArrayList;
import java.util.Arrays;

public class SubPracitce10_1 {
	public static void main(String[] args) {
		//1
		//(int i) -> {return i * i;}を簡単にする

		//Answer
		//i -> i * i;

		//2
		var list = new ArrayList<String>(Arrays.asList("キュウリ", "チンゲンサイ", "ブロッコリー", "ニンジン"));
		list.removeIf(veg -> veg.length() >= 5);
		System.out.println(list);
	}
	
}