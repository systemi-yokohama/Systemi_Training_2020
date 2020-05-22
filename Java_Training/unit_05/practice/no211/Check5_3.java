package Java_Training.unit_05.practice.no211;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Check5_3 {
	public static void main(String[] args) {
		/*
		try(var writer = Files.newBufferWriter(data.dat, Windows-31J));
		
		for(var value : args){
		}
		*/


		//→
		try(var writer = Files.newBufferedWriter(
			Paths.get("C:/work/project/Kenshu/Systemi_Training_2020/Java_Training/unit_05/practice/no211/README.md"),
			//data.dat
			Charset.forName("Window-31J"),
			StandardOpenOption.APPEND)) {
				writer.write(String.join(",", args));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}