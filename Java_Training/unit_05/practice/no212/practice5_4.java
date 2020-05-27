package Java_Training.unit_05.practice.no212;

import java.util.Arrays;

public class Practice5_4 {
	public static void main(String[] args) {
//①
	System.out.println(Math.pow(6,3));
//②
	System.out.println(Math.abs(-15));
//③
	var array = new int[]{110,14,28,32};
	Arrays.sort(array);
	System.out.println(Arrays.toString(array));
	}
}