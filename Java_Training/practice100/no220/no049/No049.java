package Java_Training.practice100.no220.no049;
import java.util.*;
import java.text.*;


public class No049 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(getRandomDate()));
	}
	
	public static Date getRandomDate() {
		// 一日前
		Calendar dateStart = Calendar.getInstance();
		dateStart.set(Calendar.DAY_OF_MONTH, -1);
		// 一日後
		Calendar dateEnd = Calendar.getInstance();
		dateEnd.set(Calendar.DAY_OF_MONTH, 1);
		// 期間日数
		long dateDiff = (dateEnd.getTimeInMillis() - dateStart.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		// ランダム日数作成
		Calendar dateRandom = Calendar.getInstance();
		dateRandom.add(dateEnd.DATE, - new Random().nextInt((int)dateDiff));
        dateRandom.add(Calendar.HOUR, getRandomInt(23));
        dateRandom.add(Calendar.MINUTE, getRandomInt(59));
        dateRandom.add(Calendar.SECOND, getRandomInt(59));
		dateRandom.add(Calendar.MILLISECOND, getRandomInt(999));		
        return dateRandom.getTime();
    }
	
	// ランダム生成
	private static int getRandomInt(int range) {
		Random rand = new Random();
        return (rand.nextInt(range));
    }
}
	