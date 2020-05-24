package Java_Training.practice100.no214;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*java.util.Date型のインスタンス変数dateを持つクラスのインスタンスのリストを、
java.util.Collectionsクラスのsort(List<T>)メソッドを用いて、
dateが示す日時の古い順にソートできるように実装せよ。
*/
public class No044 {
	
	public static void main(String[] args){
		
		List<Date> dates=new ArrayList<Date>();
			Date date1=new Date();
			SimpleDateFormat sDf= new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss:SSS");
			dates.add(date1);
			Date date2=new Date();
			dates.add(date2);
			Date date3=new Date();
			dates.add(date3);
			
			Collections.sort(dates);
			
			System.out.println(sDf.format(dates));
	}

}