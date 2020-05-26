package Java_Training.practice100.no210.no034;
import java.util.ArrayList;
import java.util.List;

public class No034 {
	public static void main(String[] args) {
		List<String> medals = new ArrayList<>();
		medals.add("gold");
		medals.add("silver");
		medals.add("bronze");

		medals.forEach(System.out::println);
	}
}