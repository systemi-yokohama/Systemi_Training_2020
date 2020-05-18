package Java_Training.practice100.no215;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class no055 {
	public static void main(String[] args){
		try (var reader=File.newBufferedReader(
			Path.get("no055.java"),
			StandardCharsets.UTF_8
		));
		while(line=reader.readline()){;
		System.out.println(line);
		}
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}