package Java_Training.practice100.no215;

import java.util.Date;
import java.text.SimpleDateFormat;

public class no047 {
	public static void main(String[] args){
	Date d = new Date();
	SimpleDateFormat day = new SimpleDateFormat("GGGGy-MM-dd- HH:mm:ss.SS");
	System.out.println(day.format(d));
	}
}