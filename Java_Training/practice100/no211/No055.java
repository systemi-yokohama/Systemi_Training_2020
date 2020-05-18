package Java_Training.practice100.no211;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.io.IOException;

public class No055 {
	public static void main(String[] args) {
		try(var reader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream("C:/work/project/Kenshu/Systemi_Training_2020/Java_Training/practice100/no211/Article.md"),
				"UTF-8"))){
					var line = "";
					while((line = reader.readLine()) != null){
						System.out.println(line);
					}	
				}catch(IOEception e){
					e.printStackTrace();
				}
	}
}