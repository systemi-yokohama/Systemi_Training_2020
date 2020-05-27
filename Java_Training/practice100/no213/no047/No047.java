package Java_Training.practice100.no213.no047;
import java.text.SimpleDateFormat;
import java.util.Date;

public class No047 {
	public static void main(String[] args) {
	var dt = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS");
	System.out.println(sdf.format(dt));
	}
}