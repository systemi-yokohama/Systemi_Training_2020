package Java_Training.practice100.no211;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class No030 {
	public String str;
	public int i;


	public static void main(String[] args) {

		final var file = "C:/work/project/Kenshu/Systemi_Training_2020/Java_Training/practice100/no211/article.ser";
		//↑シリアライズ後に保存したいファイルパス

		try(var out = new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(new Article("string", 10));
		}catch(IOException e){
			e.printStackTrace();
		}

		try(var in = new ObjectInputStream(new FileInputStream(file))){
			var a = (Article)in.readObject();
			System.out.println(a);
		}catch(ClassNotFoundException| IOException e){
			e.printStackTrace();
		}
	}
}
