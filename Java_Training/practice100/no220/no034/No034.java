package Java_Training.practice100.no220.no034;

public class No034 {
	public static void main(String[] arguments) {
        java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
		medals.add("bronze");

		medals.forEach(System.out::println);
    }
}