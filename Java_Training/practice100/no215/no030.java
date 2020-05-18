package Java_Training.practice100.no215;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.SerializedLambda;

public class no030 {
	public static void main(String[] args) {
		try (new ObjectOutputStream(new FileOutputStream("file"))){
			forSerializeClass serializeClass=new SerializeClass();
			serializeClass.setIntInstance(100);
			
		}catch(IOException e){
			e.printStackTrace();
		}

		try (new ObjectInputStream(new FileInputStream("file"))){

		}catch(ClassNotFoundException | IOException e){
			e.printStackTrace();
		}
	}
}