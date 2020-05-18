package Java_Training.practice100.no213.no058;

import java.nio.file.FileSystems;
import java.nio.file.Files;

public class No058 {
	public static void main(final String[] args) {
		public static final String BOM = "\uFEFF";
		var f = FileSystems.getDefault();
		var path = Paths.get("C:/work/aa.txt");
		
	}

	public static String aaa() {
		if(path(BOM) == true) {
			return 1;
		} else {
			return 0;
		}
	}
}