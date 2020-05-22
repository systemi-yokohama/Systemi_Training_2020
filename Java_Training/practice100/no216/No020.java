package Java_Training.practice100.no216;
import java.util.ArrayList;
import java.util.List;

public class No020 {
	private static final String[] MEDALS = new String[] {"GOLD", "SILVER", "BRONZE"};
	public static void main(String[] args) {
		final List<String> genericList = new ArrayList<String>();

		final ArrayList<String> nonGenericList = new ArrayList<String>();

		for (final String medal : MEDALS) {
			genericList.add(medal);
		}

		for (int i = 0; i < genericList.size(); i++) {
			System.out.println(genericList.get(i));
		}

		for (final String medal : MEDALS) {
			nonGenericList.add(medal);
		}

		for (int i = 0; i < nonGenericList.size(); i++) {
			System.out.println(nonGenericList.get(i));
		}
	}
}