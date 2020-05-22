package Java_Training.practice100.no211;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class No049 implements Cloneable{
	Date date = new Date();

	public No049(){
	}

	public static <Date> Date randDate(){
		var now = LocalDateTime.now();
		this.date = now.plus(Math.random(-86400, 86400), ChronoUnit.SECONDS);

		return this.date;
	}
}