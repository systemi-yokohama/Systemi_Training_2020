package Java_Training.practice100.no216;
import java.util.*;

public class DateUtil {
	public final Date randomDayAndTime() {
		Date randomDate = new Date();

		final Calendar oneAfterDay = Calendar.getInstance();
		oneAfterDay.add(Calendar.DATE, 1);

		final Calendar oneBeforeDay = Calendar.getInstance();
		oneBeforeDay.add(Calendar.DATE, -1);

		final Calendar randomDay = Calendar.getInstance();

		randomDate = randomDay.getTime();

		return randomDate;
	}
}