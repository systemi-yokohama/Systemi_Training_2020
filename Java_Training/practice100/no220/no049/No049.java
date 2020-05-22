package Java_Training.practice100.no220.no049;
import java.util.*;
import java.text.*;

public class No049 {
	// 現在時刻の取得
	Date date = new Date();
	// 書式の作成
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY年 MM月 dd日 (E) HH時 mm分 ss秒");
	// 書式の変換
	String now = sdf.format(date);

	Calendar calendar = Calendar.getInstance();
	// calendar.setTime(now);

}
	