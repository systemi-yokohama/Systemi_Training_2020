package Java_Training.practice100.no210.no020;
import java.util.ArrayList;
import java.util.List;

public class No020 {
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};

	//ジェネリクス使用
	List<String> jMedals = new ArrayList<String>(MEDALS.length);
	for(String jmedal : MEDALS) {
		jMedals.add(jmedal);
	}
	for(String jmedal2 : jMedals) {
		System.out.println(jmedal2);
	}

	//ジェネリクス未使用
	List medals = new ArrayList(MEDALS.length);
	for(String medal : MEDALS) {
		medals.add(medal);
	}
	for(String medal2 : medals) {
		System.out.println(medal2);
	}
}