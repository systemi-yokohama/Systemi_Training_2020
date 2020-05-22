package Java_Training.practice100.no220.no020;
import java.util.*;

public class No020 {

	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};
	
	// ジェネリックスなし
	// public static void noGenerics() {
	// 	List medals = new ArrayList(MEDALS.length);	
		
	// 	for(String medal : MEDALS) {
	// 		medals.add(medal);
	// 		System.out.println(medal);
	// 	}
	// }

	// ジェネリックスあり
	public static void generics() {
		List<String> medals = new ArrayList<String>(MEDALS.length);
		for(String medal : MEDALS) {
			medals.add(medal);
			System.out.println(medal);
		}
	}

	public static void main(String[] args) {
		// noGenerics();
		System.out.println("--------");
		generics();
	}
}