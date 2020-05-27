package Java_Training.practice100.no220.no044;
import java.util.*;
import java.text.*;

public class No044 {
	public static void main(String[] args) {
	Date date = new Date();
	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分 ss秒");
	
	// リスト追加
	No044_2 date1 = new No044_2();
	No044_3 date2 = new No044_3();
	List<String> datelist = new ArrayList<String>();
		datelist.add(sdformat.format(date));
		datelist.add(date1.cldate1());
		datelist.add(date2.cldate2());
		System.out.println("ソート前：" + datelist);
	
	// ソート
	Collections.sort(datelist);
		System.out.println("ソート後：" + datelist);
	

	}
}
