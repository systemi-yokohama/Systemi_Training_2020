package Java_Training.practice100.no220.no057;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;


public class No057 {
	public static void main(String[] args) {

		Path file = Paths.get("C://work//project//Kenshu//Systemi_Training_2020//Java_Training//practice100//no220//no057","test.txt");
		Path fileCopy = Paths.get("C://work//project//Kenshu//Systemi_Training_2020//Java_Training//practice100//no220//no057","test.read.txt");
		Charset charset = Charset.forName("UTF-8");

        try {
        	List<String> line = Files.readAllLines(file,charset);
            for (String s : line) {
                System.out.println(s);
			}
			// ファイルのコピー
			Files.copy(file, fileCopy, StandardCopyOption.REPLACE_EXISTING);
			// 元ファイルの削除
			Files.deleteIfExists(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}