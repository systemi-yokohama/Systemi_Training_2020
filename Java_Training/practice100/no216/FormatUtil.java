package Java_Training.practice100.no216;
import java.util.Date;
import java.text.SimpleDateFormat;


public class FormatUtil {
	public final String dayAndTime(final Date date) {
		if (date == null) {
			return null;
		}

		final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

		return df.format(date);
	}
}