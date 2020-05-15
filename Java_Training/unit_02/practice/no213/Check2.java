/* [1] 
1.変数にString型のデータ型、データ型省略のvarが入っていないため、変数定義ができていない。
2.文字列なのにシングルクォーテーションで囲まれている。
3.出力命令の末尾にシングルクォーテーションがついていない。


[2]
1.完全修飾名
2.単純名
3.import命令
4.解決


[3]
1.final
2.0.1
3.DISCOUNT
4.println
5.int


[4]
1.〇
2.×
3.×
4.×
5.× */

package Java_Training.unit_02.practice.no213;

public class Check2 {
	public static void main(String[] args) {
		var value = 10d;
		System.out.println("ようこそ\nJavaの世界へ");
		String str = null;
		int[][] data = new int[5][4];
		var list = new int[][] {
			{ 2, 3, 5 },
			{ 1, 2 },
			{ 10, 11, 12, 13},
		};
	}
}