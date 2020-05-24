package Java_Training.practice100.no215;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class no057 {
	
	public static void main(String[] args) {
		if (args.length < 1 ) {
            System.out.println("終了");  
        }

		try (var reader=Files.newBufferedReader(Paths.get("no057.java.txt"),StandardCharsets.UTF_8)){
				var line="";
				while((line=reader.readLine()) !=null){
					System.out.println(line);
					Path sourcePath = Paths.get("no057.txt");
                	Path targetPath = Paths.get("no057_2.txt");
                    Files.copy(sourcePath, targetPath);
					
					Files.deleteIfExists(sourcePath);

				} 
				}catch(IOException e){
					e.printStackTrace();
				}
		}
	}

