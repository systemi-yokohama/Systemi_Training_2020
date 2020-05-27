package Java_Training.practice100.no210.no047;
import java.text.SimpleDateFormat;
import java.util.Date;

public class No047 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("y-MM-dd HH:mm:ss.SSS");
		
		var input = new Date();
		
		if(input.equals(null)) {
			System.out.println("null");
		} else {
			System.out.println(sdf.format(input));
		}
	}
}