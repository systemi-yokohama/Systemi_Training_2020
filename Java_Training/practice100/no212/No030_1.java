/*
シリアライズ
・java.lang.String型とint型のインスタンス変数を持つクラスをシリアライズしてファイルに保存し、
そのファイルを読み込んでデシリアライズするプログラムを実装
・・java.io.ObjectOutputStream および java.io.ObjectInputStreamを使用
・・デシリアライズ後にシリアライズ前の変数値が復元されていることを確認
*/

package Java_Training.practice100.no212;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

final var file = "C:/data/article.ser"

public class No030_1 {
	public static void main(String[] args) {
	try(var out = new ObjectOutputStream(new FileOutputStream(file))){
		out.writeObject(new Article("aaaaa","bbbbb",false));
	}catch(IOException e){
	}

	try(var in = new ObjectInputStream(new FileInputStream(file))){
		var a = (No030)in.readObject();
		System.out.println(a);
	}catch(ClassNotFoundException | IOException e){
		e.printStackTrace();
	}
}
}