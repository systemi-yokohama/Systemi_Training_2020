package Java_Training.practice100.no214;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

import jdk.dynalink.StandardOperation;

/*java.io 配下のパッケージのAPIを用いずに（java.nio 配下のパッケージのAPIを用いて）、
コマンドの第1引数に指定されたテキストファイル(UTF-8形式)を読み込んで標準出力に出力しつつ、
 元のファイル名.read という名前のファイルにコピーを作成し、
読み込みが完了したら元のファイルを削除するプログラムを実装せよ。*/
public class No057 {
	try (var in =new BufferedInputStream(new FileInputStream(file),StandardCharsets.UTF-8));
	    var out =new BufferedOutputStream(new FileOutputStream(file)){
		while((line=reader.readerLine())!=null){
			Systemi.out.println(line);
		}
	} catch (IOException e ) {
		e.printStackTrace();
	}
	try (var in =new ObjectInputStream(new FileInputStream(file))){
		var a=(file)in.readObject();
		System.out.println(a);
	} catch (ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
}
