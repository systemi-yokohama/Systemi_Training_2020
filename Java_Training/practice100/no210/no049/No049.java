package Java_Training.practice100.no210.no049;
import java.util.Date;
import java.util.Random;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class No049 {
	public static void main(String[] args) {
		var now = new Date();
		var yesterday = now.minus(1, ChronoUnit.DAYS);
		var tomorrow = now.plus(1, ChronoUnit.DAYS);

		Date randomDate = new Date(ThreadLocalRandom.nextLong(yesterday.getTime(), tomorrow.getTime()));
	}
}