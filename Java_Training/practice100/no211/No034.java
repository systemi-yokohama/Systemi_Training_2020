package Java_Training.practice100.no211;

public class No034 {
	public static void main(String[] arguments) {
        java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
        medals.add("bronze");
		medals.
			//→stream().
			forEach(System.out::println);
		//43文字
		//→stream()は省略できる
    }
}