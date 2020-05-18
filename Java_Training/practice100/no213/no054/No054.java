package Java_Training.practice100.no213.no054;

public class No054 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
			} else {
				continue;
			}
		}
		System.out.println(sum);
	}
}