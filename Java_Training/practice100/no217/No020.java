package Java_Training.practice100.no217;

import java.util.ArrayList;
import java.util.List;

public class No020 {
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	 };
	public static void main(final String[] args) throws InterruptedException {
		Generic();
        NotGeneric();
	}
	
	private static void Generic() {
        final List<String> medals = new ArrayList<String>(MEDALS.length);
        for (final String medal : MEDALS) {
            medals.add(medal);
        }
        for (final String medal : medals) {
            System.out.println(medal);
        }
	}
	
	private static void NotGeneric() {
        final List medals = new ArrayList(MEDALS.length);

        for (final Object medal : MEDALS) {
            medals.add(medal);
        }

        for (final Object medal : medals) {
            System.out.println(medal);
        }
    }
}

