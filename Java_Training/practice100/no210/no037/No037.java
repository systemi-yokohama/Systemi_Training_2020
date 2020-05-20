package Java_Training.practice100.no210.no037;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public final class No037 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("yyyy/mm/dd");
		
		List<Date> list = new ArrayList<>();

		try{
			Date date1 = new Date();	
			Date date2 = sdf.parse("2019/05/01");
			Date date3 = sdf.parse("2018/05/01");

			list.add(date1);
			list.add(date2);
			list.add(date3);
		} catch(ParseException e) {
            e.printStackTrace();
        }  

		//シャローコピー
		List<Date> shallow = list;

		//ディープコピー
		List<Date> deep = new ArrayList<>(list);

		//listの操作
		try{
			Date date4 = sdf.parse("2020/05/01");
			list.add(date4);
		} catch(ParseException e) {
            e.printStackTrace();
		} 
		
		//それぞれの出力  
		System.out.println(shallow);
		System.out.println(deep);

	}
}