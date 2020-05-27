/*
シリアライズ
・java.lang.String型とint型のインスタンス変数を持つクラスをシリアライズしてファイルに保存し、
そのファイルを読み込んでデシリアライズするプログラムを実装
・・java.io.ObjectOutputStream および java.io.ObjectInputStreamを使用
・・デシリアライズ後にシリアライズ前の変数値が復元されていることを確認
*/

package Java_Training.practice100.no212;

import java.io.Serializable;

public class No030 implements Serializable{
	private static final long serialVersionUID = 1L;
	public String title;
		public int number;

		public No030(String title,int number){
			this.title = title;
			this.number = number;
		}

}