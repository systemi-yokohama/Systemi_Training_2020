package Java_Training.practice100.no213.no057;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class No057 {
	public static void main(String[] args) {
		try {
			var f = FileSystems.getDefault();
			var path = Paths.get("C:/work/aa.txt");
			Files.readString(path);
			Files.copy(path, f.getPath("C:/work/aa.read"), 
			StandardCopyOption.REPLACE_EXISTING);
			Files.deleteIfExists(path);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}