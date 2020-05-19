package Java_Training.practice100.no214;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

import jdk.dynalink.StandardOperation;

public class No057 {
	public static void Main(String[] args){
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
}