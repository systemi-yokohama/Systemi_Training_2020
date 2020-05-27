package Java_Training.practice100.no220.no079;
import java.io.*;

public class No079 {

	public No079() throws IOException {
	File file = new File("test.txt");
	file.createNewFile();

	File dir = new File("test");
	dir.mkdir();
	
	File fileIn = new File("/java/test.txt");
	File fileOut = new File("/test/test.txt");
	fileIn.renameTo(fileOut);
	
	}
	
}