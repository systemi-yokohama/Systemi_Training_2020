package Java_Training.practice100.no215;

import java.util.ArrayList;
import java.util.List;

public class no020 {
	
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};


	private static void generic(){
		List<String> medals = new ArrayList<>(MEDALS.length);
		
		for (final String medal : MEDALS) {
            medals.add(medal);
        }
		for(String medal:MEDALS){
			System.out.println(medal);
	
		}
	}

	public static void nogeneric(){
		List<String> medals = new ArrayList<>(MEDALS.length);
		
		for (final Object medal : MEDALS) {
            medals.add((String) medal);
        }
		for(String medal:MEDALS){
			System.out.println(medal);
		}
	}

	public static void main(final String[] args) throws InterruptedException {
        generic();
        nogeneric();
    }

}