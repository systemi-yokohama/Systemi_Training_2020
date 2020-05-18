package Java_Training.unit_05.practice.no220;
import java.util.Arrays;

public class Practice5_4 {
	public static void main(String[] args) {

		// 問1
		double val1 = Math.pow(6, 3);
		System.out.println(Math.round(val1));
		
		// 問2
		int val2 = Math.abs(-15);
		System.out.println(val2);

		// 問3
		int[] values = {110, 14, 28, 32};
		Arrays.sort(values);

		for(int value : values) {
			System.out.println(value);
		}

		}
	}

