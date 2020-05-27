package Java_Training.practice100.no210.no079;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;

public class No079 {
	
	public void func(ArrayList<String>[] srcFile, String folder) throws IOException {
		for(var file : srcFile) {

			var wError = Files.newBufferedWriter(Paths.get("wrror.txt"));
			var wSuccess = Files.newBufferedWriter(Paths.get(folder));
			var reader = Files.newBufferedReader(Paths.get(file.toString()));

			try{
				
				var line = "";
				while((line = reader.readLine()) != null) {
					wSuccess.write(line);
				}

			} catch(IOException e) {
				wError.write(file.toString());
			} 
		}
	}
}