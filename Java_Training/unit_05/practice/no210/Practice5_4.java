package Java_Training.unit_05.practice.no210;
import java.lang.Math;
import java.util.Arrays;

public class Practice5_4 {
	public static void main(String[] args) {
		//1
		System.out.println(Math.pow(6, 3));

		//2
		System.out.println(Math.abs(-15));

		//3
		var ar = new int[] {110, 14, 28, 32};
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
	}
}