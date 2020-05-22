package Java_Training.practice100.no215;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class no055 {
	public static void main(String[] args) {
		
		try (var reader = Files.newBufferedReader(Paths.get("C:no055.java.txt"), StandardCharsets.UTF_8)) {
			var line = "";
			int sum = 0;
				while((line=reader.readLine())!=null){
				
				System.out.println(line.length());
				sum += line.length();
				}
				System.out.println(sum);
		
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}	
