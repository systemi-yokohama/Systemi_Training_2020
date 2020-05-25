package Java_Training.practice100.no214;
//import java.io.ObjectInput;
//import java.io.OutputStream;
//import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
import java.io.IOException;
/*java.lang.String型とint型のインスタンス変数を持つクラスをシリアライズしてファイルに保存し、
そのファイルを読み込んでデシリアライズするプログラムを実装せよ。
java.io.ObjectOutputStream および java.io.ObjectInputStream を使用せよ。
デシリアライズ後にシリアライズ前の変数値が復元されていることを確認せよ。 */

class No030B{
public static void main(String[] args){
	final var file="C:/data/data.ser";

	try (var out=new ObjectOutputStream(new FileOutputStream(file))){
	  out.writeObject("ddd");
  } catch (IOException e) {
	e.printStackTrace();  
  }

	
	try (var in =new ObjectInputStream(new FileInputStream(file))){
		var a=(No030A)in.readObject();
		System.out.println(a);
	} catch (ClassNotFoundException|IOException e) {
		e.printStackTrace();
	}	


}
}