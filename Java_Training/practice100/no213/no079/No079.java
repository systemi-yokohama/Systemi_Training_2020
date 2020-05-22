package Java_Training.practice100.no213.no079;

import java.io.File;

public class No079 {
	public static void main(final String[] args) {
		File file = new File("##.txt");
		new File("error.txt");
		File[] list = file.listFiles();
		String path = System.getProperty("user.dir");

		if(list != null) {
			System.out.println(list.length);
		} else {
			System.out.println(path);
		}
		
	}
}