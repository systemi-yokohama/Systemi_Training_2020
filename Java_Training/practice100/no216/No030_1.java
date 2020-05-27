package Java_Training.practice100.no216;
// java.lang.String型とint型のインスタンス変数を持つクラスを
// シリアライズしてファイルに保存し、
// そのファイルを読み込んでデシリアライズするプログラムを実装せよ。
// java.io.ObjectOutputStream および 
// java.io.ObjectInputStream を使用せよ。
// デシリアライズ後にシリアライズ前の変数値が復元されていることを確認せよ。

import java.io.Serializable;


public class No030_1 implements Serializable {
	private static final long serialVersionUID = 1L;
	public String title;
	public int number;

	public No030_1(String title, int number) {
		this.title = title;
		this.number = number;
	}
}