/*
ラムダ式
・0～9の整数が1つずつ入った10個を要素に持つリストに対して、奇数だけを標準出力するプログラムをラムダ式を用いて実装
*/

package Java_Training.practice100.no212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class No033 {
	var list = new ArrayList<Int>(
		Arrays.asList(0,1,2,3,4,5,6,7,8,9);
	)
	.filter(number -> isOddNumber(number))
	.forEach(System.out::println);
}
