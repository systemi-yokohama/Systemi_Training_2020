/*
コアAPI:java.lang.Comparable
・java.util.Date型のインスタンス変数dateを持つクラスのインスタンスのリストを、java.util.Collectionsクラスの
sort(List<T>)メソッドを用いて、dateが示す日時の古い順にソートできるように実装

Date クラスを３つ生成（引数なし、引数 A、引数 B） 生成したオブジェクトをコレクションクラスに格納してソートする
*/
package Java_Training.practice100.no212;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class No044 {
	public static void main(String[] args) {
		List<Date> list = new ArrayList<Date>();
		var zdt1 = ZonedDateTime.of(2020, 1, 10, 10, 20, 30, 999, ZoneId.of("Asia/Tokyo"));
		var zdt2 = ZonedDateTime.of(2020, 1, 10, 10, 20, 30, 999, ZoneId.of("Europe/Berlin"));
		var zdt3 = ZonedDateTime.of(2020, 1, 10, 10, 20, 30, 999, ZoneId.of("Pacific/Honolulu"));
	
		Collections.sort(list);
	}
}


