package Java_Training.practice100.no214;
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
//import java.nio.file.Paths;
import java.nio.*;
import java.io.FileReader;

//import jdk.dynalink.StandardOperation;
/*java.io 配下のパッケージのAPIを用いずに（java.nio 配下のパッケージのAPIを用いて）、
コマンドの第1引数に指定されたテキストファイル(UTF-8形式)を読み込んで標準出力に出力しつつ、
 元のファイル名.read という名前のファイルにコピーを作成し
、読み込みが完了したら元のファイルを削除するプログラムを実装せよ */
// var out =new BufferedOutputStream(new FileOutputStream(file))
public class No057 {
	public static void main(String[] args){
	final var file="C:/data/data.log";
	final var file2="C:/data/data.read";
	try (var reader =new Files.newBufferedReader(
		new FileInputStream(file),StandardCharsets.UTF_8);
	   ){
		   var line=" ";
		while((line=reader.readerLine())!=null){
			System.out.println(line);

		}
	} catch (IOException e ) {
		e.printStackTrace();
	}
	
	try (var in =new ObjectInputStream(new FileInputStream(file))){

	} catch (ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
}
}