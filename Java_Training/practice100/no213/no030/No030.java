package Java_Training.practice100.no213.no030;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class No030 {
	public static void main(final String[] args) {
		try ( var out = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
				out.writeObject(new Class(12, "aa"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}