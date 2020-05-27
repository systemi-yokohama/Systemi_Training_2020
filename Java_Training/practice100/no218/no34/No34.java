package Java_Training.practice100.no218.no34;

public class No34 {

	public static void main(final String[] args) {
		final java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
		medals.add("bronze");
		medals.forEach(System.out::println);
 
	}
	
}