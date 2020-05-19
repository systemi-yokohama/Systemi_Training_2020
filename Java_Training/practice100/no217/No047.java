package Java_Training.practice100.no217;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class No047 {
	public static void main(final String[] args) {
        Calendar dayAndTime = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss.SS");
        System.out.println(sdf.format(dayAndTime.getTime()));
    }
}