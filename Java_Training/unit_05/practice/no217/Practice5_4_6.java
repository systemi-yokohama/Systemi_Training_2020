package Java_Training.unit_05.practice.no217;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Practice5_4_6 {
	public static void main(String[] args){
		try (var a = Files.newBufferedWriter(
			Paths.get(C:\date\data.bat),
			Charset.forName("Windows-31J"),
			StandardOpenOption.APPEND)) {
				a.write(String.join(",",args));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
