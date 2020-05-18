package Java_Training.practice100.no210.no079;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class No079 {
	public static void main(String[] args) {
		
	}

	public void func(ArrayList[] srcFile, String folderPaths) {
		try (var writer = Files.newBufferedWriter(Paths.get("error.txt"))){
			for(var file : srcFile) {
				if(!(Files.move(Paths.get(file), folderPaths))) {
					writer.write(Paths.get(file));
				} 
			} 
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}