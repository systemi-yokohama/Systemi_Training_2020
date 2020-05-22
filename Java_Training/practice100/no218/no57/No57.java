package Java_Training.practice100.no218.no57;


import java.nio.file.FileSystems;

public class No57 {

	public static void main(String[] args){

		String spa = FileSystems.getDefault().getSeparator();

		try{
			Path sourcePath = Paths.get("." + spa + "");
		}
	}
}