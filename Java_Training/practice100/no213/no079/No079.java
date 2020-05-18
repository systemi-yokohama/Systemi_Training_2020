package Java_Training.practice100.no213.no079;

import java.io.File;

public class No079 {
	public static void main(final String[] args) {
		File file = new File("##.txt");
		File fl = new File("error.txt");
		File[] list = dir.listFiles();
		String path = System.getProperty("user.dir");

		if(list != null) {
			System.out.println(list.length);
		} else {
			System.out.println(file);
		}
		
	}
}