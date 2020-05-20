package Java_Training.unit_05.practice.no217;
import java.util.Calendar;
import java.text.SimpleDateFormat;

//参考サイト（https://www.sejuku.net/blog/20994）

public class Practice5_3 {
	public static void main(String[] args){
		//Calendarクラスのオブジェクトを生成
        Calendar nowday = Calendar.getInstance();
        
        //SimpleDateFormatクラスでフォーマットパターンを設定する
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
        System.out.println("現在：" + sdf.format(nowday.getTime()));
		
        //フォーマットを変更
        //01.月と分を出力
        sdf.applyPattern("MM月mm分");
        System.out.println("現在（月,分）：" + sdf.format(nowday.getTime()));

        //02.20日後の出力
        sdf.applyPattern("MM月dd日");
        nowday.add(Calendar.DATE, 20);
        System.out.println("20日後：" + sdf.format(nowday.getTime()));
	}
}