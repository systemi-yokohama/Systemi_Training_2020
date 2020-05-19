package Java_Training.unit_05.practice.no218;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class test_3 {
	public static void main(String[] args){


		try(var reader = Files.newBufferedWriter(
			Paths.get("C:/data/data.dat"),Charset.forName("Windows-s1J"),
		    StandardOpenOption.APPEND)){
		      writer.write(String.join(",", args));
		    } catch (IOException e) {
			    e.printStackTrace();
		}

	}
	
}