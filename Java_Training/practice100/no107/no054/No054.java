package Java_Training.practice100.no107.no054;

public class No054 {
	public static void main(String[] args) {

		int sumEvenNunmber = 0;

		for (int i = 1; i <= 100; i++) {

			if (i % 2 == 0) {
				// System.out.println(i);
				sumEvenNunmber += i;

			}

		}
		System.out.println(sumEvenNunmber);

	}

}