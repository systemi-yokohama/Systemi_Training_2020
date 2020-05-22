package Java_Training.practice100.no220.no049;
import java.util.*;
import java.text.*;

public class No049 {

	public static void main(String[] args) {
	// Date型書式の作成
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY年 MM月 dd日 (E) HH時 mm分 ss秒");
	
	// 現在時刻の取得
	Calendar calendar = Calendar.getInstance();

	// calendar型の日時をDate型に変換する
	Date now = calendar.getTime();
	
	// 1日前の日時
	calendar.add(Calendar.DATE, -1);
	Date yesterday = calendar.getTime();
	
	// 1日後の日時
	calendar.add(Calendar.DATE, 2);
	Date tommorow = calendar.getTime();

	Random random = new Random();

	}
}
	