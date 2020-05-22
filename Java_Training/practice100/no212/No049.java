//コアAPI:java.util.Date,Calender
//現在時刻からプラスマイナス１日の範囲でランダムな日時を示すjava.util.Dateオブジェクトを生成するユーティリティメソッドを持つクラスDateUtilの実装

//LocalDateTimeで現在時刻と日付入手→プラスマイナス１の範囲という条件で何かを規定？→ランダムで示すメソッド作成？
package Java_Training.practice100.no212;

import java.util.Date;
import java.time.LocalTime;

public class No049{
       public static void main(String[] arguments) {
       System.out.Println(DateUtil.getRandomDate());
}
}
