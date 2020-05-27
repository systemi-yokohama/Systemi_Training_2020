package Java_Training.practice100.no220.no054;

public class No054 {
	public static void main(String[] args) {
		int result = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				result += i;
			} else {
				continue;
			}
		}
		System.out.println(result);
	}
}