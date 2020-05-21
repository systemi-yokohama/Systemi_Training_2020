package Java_Training.practice100.no215;

import java.nio.file.Files;

public class no057 {
	
	public static void main(String[] args) {
		if (args.length < 1 ) {
            System.out.println("終了");  
        }

		try (var reader=File.newBufferedReader(
			Path.get("no057.java"),
			StandardCharsets.UTF_8
		))
		while(line=reader.readline()){;
			System.out.println(line);
			Files.copy(in, target, options);
			Files.deleteIfExists(path);

		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}