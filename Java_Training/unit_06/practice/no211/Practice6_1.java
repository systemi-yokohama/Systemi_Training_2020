/*
[1]
ジェネリックス：汎用的なクラス・メソッドを特定の型に紐づけるための仕組み

ジェネリックスを用いることで
格納する型が正しいことをコンパイル時にチェックでき、
値を取り出すときのキャストも不要になる。
＝型安全(タイプセーフ)
*/


//[2]
package Java_Training.unit_06.practice.no211;
import java.util.ArrayList;
import java.util.Arrays;

public class Practice6_1 {
	public static void main(String[] args) {
		var list = new ArrayList<Integer>(Arrays.asList(16, 24, 30, 39));
		for(Integer data: list){
			System.out.println(data);
		}
	}
}