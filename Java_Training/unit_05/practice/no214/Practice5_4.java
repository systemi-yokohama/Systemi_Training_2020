package Java_Training.unit_05.practice.no214;
import java.lang.Math;
import java.util.Arrays;
public class Practice5_4 {
public static void main(String[] args) {
//6の3乗
	System.out.println(Math.pow(6,3));
//-15の絶対値
	System.out.println(Math.abs(-15));
//110,14,28,32といった値を持つ配列を定義してソートする
	 var array1=new int[] {110,14,28,32};
	 Arrays.sort (array1);
	 System.out.println(Arrays.toString(array1));

}	
}