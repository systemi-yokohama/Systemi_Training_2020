package Java_Training.practice100.no210.no049;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class No049 {
	public static void main(String[] args){
		//開始
		Calendar dateStart = Calendar.getInstance();
		dateStart.add(Calendar.DAY_OF_MONTH, 1);

		//終了
		Calendar dateEnd = Calendar.getInstance();
		dateEnd.add(Calendar.DAY_OF_MONTH, -1);

		long dateDiff = (dateEnd.getTimeInMillis() - dateStart.getTimeInMillis())/ (1000 * 60 * 60 * 24);

		//ランダム
		Calendar dateRandom = Calendar.getInstance();
		dateRandom.add(dateEnd.DATE, - new Random().nextInt((int)dateDiff));
		dateRandom.add(dateEnd.HOUR_OF_DAY, - new Random().nextInt((int)dateDiff));


		Date date = new Date();
		date = dateRandom.getTime();
		System.out.println(date);
	}
}