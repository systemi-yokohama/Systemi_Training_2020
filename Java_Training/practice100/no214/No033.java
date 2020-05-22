package Java_Training.practice100.no214;
/*33：ラムダ式
0～9の整数が1つずつ入った10個を要素に持つリストに対して、
奇数だけを標準出力するプログラムをラムダ式を用いて実装せよ。 */

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.function.Consumer;


public class No033 {
	public static void main(Integer[]args){
		var list =new ArrayList<Integer>(
			Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		list.removeIf(v->(1==v%2));
			System.out.println(list);
		//var data=new int[]{0,1,2,3,4,5,6,7,8,9};
		//No033 on = new No033();
		//on.OddNumber(data,(var value)->{
			//System.out.printf("%d",value);
	}
	

}

	
/**
 * public int OddNumber(String[] data,UnaryOperator <Integer> output){
		for(var value:data){
			if( 1 == value % 2){
				output.apply(value);
			}
		}

	}
class main{
	public static void main(String[] args){
		var data=new int[]{0,1,2,3,4,5,6,7,8,9};
		No033 on = new No033();
		on.OddNumber(data,(var value)->{
			System.out.printf("%d",value);
		}
	}
}
 */