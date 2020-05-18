package Java_Training.practice100.no215;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.SerializedLambda;

public class no030 {
	public static void main(String[] args) {
		try (var out=new ObjectOutputStream(new FileOutputStream("file"))){
			forSerializeClass serializeClass=new SerializeClass();
			public String s;
			public int i;

			public Article(String s,int i){
				this.a=a;
				this.i=i;
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}

		try (var in=new ObjectInputStream(new FileInputStream("file"))){
			var a=(Article)in.readObject();
			System.out.println(a);
		}catch(ClassNotFoundException | IOException e){
			e.printStackTrace();
		}
	}
}