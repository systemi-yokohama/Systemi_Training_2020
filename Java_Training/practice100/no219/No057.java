package Java_Training.practice100.no219;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class No057 {
	public static void main(String[] args) {
		DirectoryStream<Path> directoryStream;
		
		File in =new File("C://work/project/kenshu/Systemi_Training_2020/Java_Training/practice100/no219/no055");
		File out =new File("C://work/project/kenshu/Systemi_Training_2020/Java_Training/practice100/no219/no055");

		try{
			directoryStream=Files.newDirectoryStream(in.toPath());
			directoryStream.forEach(Path ->{
				if (Path.getFileName().toString().endsWith(".txt")){
					try{
						Files.copy(Path,out.toPath().resolve(Path.normalize().toString().replace(".java",".txt")),StandardCopyOption.REPLACE_EXISTING);

					}catch (IOException e){
						e.printStackTrace();
					}
				}
			});
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}