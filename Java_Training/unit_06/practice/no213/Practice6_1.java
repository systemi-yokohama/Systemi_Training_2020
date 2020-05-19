/* [1]
	ジェネリクスは汎用的なクラスやメソッドを特定の型に紐づける仕組み
	各々の型にあてはめることによって専用のリストが作れる
	メリットはコンパイルしたときに型が値にあっているかチェックできたり
	値を取り出すときのキャストが要らなくなること */

package Java_Training.unit_06.practice.no213;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice6_1 {
	public static void main(String[] args) {
		var array = new ArrayList<Integer>(Arrays.asList(16, 24, 30, 39));
	}
}