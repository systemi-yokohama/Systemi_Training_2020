package Java_Training.unit_05.practice.no210;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;

public class Practice5_3 {
	public static void main(String[] args) {
		try(var writer = Files.newBufferedWriter(
			Paths.get("C:/data/data/dat"),
			Charset.forName("Windows-31J"),
			StandardOpenOption.APPEND
		)) {
			writer.write(String.join(",",args));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}