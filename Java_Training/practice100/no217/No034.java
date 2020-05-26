package Java_Training.practice100.no217;

public class No034 {
	public static void main(String[] arguments) {
        java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
		medals.add("bronze");
		// 36文字以内の出力
        medals.forEach(System.out::println);
    }
}