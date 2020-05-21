package Java_Training.practice100.no219;

public class No020 {
	private static final String[] MEDALS = new String[]{
		"GOLD", "SILVER", "BRONZE"
	};
	public static < A > void printArray( A[] inputArray ){
             
         for ( A element : inputArray ){        
            System.out.printf( "%s ", element );
         }
         System.out.println();
	}
	
	public static void main(String[] args) {
		printArray( MEDALS );
	}
}