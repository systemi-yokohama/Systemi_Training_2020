package Java_Training.unit_05.practice.no214;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.Period;

//クラスを利用して以下のコードを書く
public class Practice5_1 {
	/*String/LocalDateTimeクラスを利用して以下のコードを書く */
	public static void main(String[] args) {
	/*[となりのきゃくはよくきゃくくうきゃくだ]の最後に登場する[きゃく]の位置を検索する */
		var str="となりのきゃくはよくきゃくくうきゃくだ";
		System.out.println(str.indexOf("きゃく"));
	
	/*「●○の気温は●○℃です。」という書式文字列に千葉と17.256という数値を埋め込む。(小数点2桁まで表示) */
		System.out.println(String.format("%cの気温は%.2d℃です","千葉",17.256 ));

	/*[彼女の名前は花子です。]に含まれる「彼女」を「妻」に置き換える。 */
	    var intro="彼女の名前は花子です。";
	    System.out.println(intro.replace("彼女","妻"));
    /*現在の日時を基点に５日と６時間後の日時を求める */
		var ldt= LocalDateTime.now();
		 ldt=ldt.plus(5,ChronoUnit.DAYS);
		 ldt=ldt.plus(6,ChronoUnit.HOURS);
		 System.out.println(ldt);

	/*2020/03/12から2020/11/05までの差を「××ヶ月××日間」の形式で出力する */
		var date1 = LocalDateTime.of( 2020 , 03 , 12);
		var date2 = LocalDateTime.of( 2020 , 11 , 05);
		var date1_2=Period.between(date1, date2);
		System.out.println(Period.getMonths() + "年" + Period.getDays() + "日間");

}
}