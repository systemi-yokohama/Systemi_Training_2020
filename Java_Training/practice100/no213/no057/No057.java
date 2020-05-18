package Java_Training.practice100.no213.no057;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class No057 {
	public static void main(String[] args) {
		var f = FileSystems.getDefault();
		var path = Paths.get("C:/work/aa.txt");
		String text = Files.readString(path);
		var path2 = Files.copy(path, f.getPath("C:/work/aa.read"), 
		StandardCopyOption.REPLACE_EXISTING);
		Files.deleteIfExists(path);
	}	
}