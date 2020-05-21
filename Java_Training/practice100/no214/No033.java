package Java_Training.practice100.no214;
/*33：ラムダ式
0～9の整数が1つずつ入った10個を要素に持つリストに対して、
奇数だけを標準出力するプログラムをラムダ式を用いて実装せよ。 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.ArrayList;

public class No033 {
	public int OddNumber(String[] data,UnaryOperator <Integer> output){
		for(var value:data){
			if( 1 == value % 2){
				output.apply(value);
			}
		}

	}
    public static void main(String[] args){
		var data=new int[]{0,1,2,3,4,5,6,7,8,9};
		var on = new OddNumber();
		on.OddNumber(data,(int value)->{
			System.out.printf("%d",value);
		}
	}
}
