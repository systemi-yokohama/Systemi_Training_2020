package Java_Training.unit_02.practice.no210;

public class Practice2_5 {
	public static void main(String[] args) {
		//1
		var value = 10d;  
		System.out.println(value);

		//2
		System.out.println("ようこそ、\nJavaの世界へ！");

		//3
		String str = null;
		System.out.println(str);

		//4
		int[][] data = new int[5][4];
		System.out.println(data);

		//5
		var list = new int[][] {
			{2, 3, 5},
			{1, 2},
			{10, 11, 12, 13}
		};
		System.out.println(list);
	}
}