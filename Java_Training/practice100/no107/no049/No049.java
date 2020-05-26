package Java_Training.practice100.no107.no049;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Random;

public class No049 {
	public static void main(String[] args) {
		// 1. 現在日時を取得
		// 2. 現在時刻からプラスマイナス1日の範囲でランダムな日時を示す

		// 日時のフォーマット
		String dayFormat = "yyyy/MM/dd H:MM:SS";

		SimpleDateFormat sdf = new SimpleDateFormat(dayFormat);

		// 現在日時の取得(Calender)
		Calendar cal = Calendar.getInstance();
		System.out.println("現在日時(Calendar): " + sdf.format(cal.getTime()));

		// 範囲の取得 翌日の現在時分~前日の現在時分 -> 48時間
		long diff = 48 * 60 * 60;

		Calendar dateRandom = Calendar.getInstance();
		dateRandom.add(Calendar.DATE, 1);
		dateRandom.add(dateRandom.SECOND, -new Random().nextInt((int) diff));

		System.out.println("diff: " + diff);
		System.out.println("rand: " + new Random().nextInt((int) diff));

		System.out.println("ランダム" + sdf.format(dateRandom.getTime()));

	}
}