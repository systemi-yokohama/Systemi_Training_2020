package Java_Training.unit_04.practice.no220;

public class Practice4_3 {
	public static void main(String[] args) {
		int result = 0;
		for (int i = 100; i <= 200; i++) {
			if(i % 2 == 0) {
				continue;
			} else {
				result += i;
			}
		}
		System.out.println("奇数の合計値は" + result + "です");

	}
}
