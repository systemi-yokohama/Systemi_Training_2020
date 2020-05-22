package Java_Training.practice100.no214;
import java.io.ObjectInput;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
/*java.lang.String型とint型のインスタンス変数を持つクラスをシリアライズしてファイルに保存し、
そのファイルを読み込んでデシリアライズするプログラムを実装せよ。
java.io.ObjectOutputStream および java.io.ObjectInputStream を使用せよ。
デシリアライズ後にシリアライズ前の変数値が復元されていることを確認せよ。 */

public class No030 implements Serializable{ 
  private static final long SerializableUID=1L;
  public String title;
  public int data;

public No030 (String title,int data){
	this.title=title;
	this.data=data;

}	

public ObjectOutputStream (OutputStream FileOutputStream){
	final String file="C:/data/data.ser";
  try (final var out=new ObjectOutputStream(new FileOutputStream(file))){
	  out.writeObject("ddd");
  } catch (IOException e) {
	e.printStackTrace();  
  }
}
public ObjectInputStream(InputStream FileiInputStream){
	final String file="C:/data/data.ser";
	try (var in =new ObjectInputStream(new FileInputStream(file))){
		var a=(No030)in.readObject();
		in.readObject();
		System.out.println(data);
	} catch (ClassNotFoundException|IOException e) {
		e.printStackTrace();
	}
}	




}