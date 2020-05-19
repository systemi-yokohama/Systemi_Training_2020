package Java_Training.unit_05.practice.no218;

import java.util.Arrays;

public class test_4 {
	public static void main(String[] args){

		//①6の3乗を求める
        System.out.println(Math.pow(6,3));

		//②-15の絶対値を求める
        System.out.println(Math.abs(-15));

		//③110, 14, 28, 32といった配列を定義し、これをソートする
		int n[] = {110,14,28,32};
		Arrays.sort(n);
        System.out.println(Arrays.toString(n));

	}
	
}