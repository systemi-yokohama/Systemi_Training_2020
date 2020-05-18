package Java_Training.practice100.no210.no037;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public final class No037 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("yyyy/mm/dd");
		
		var date1 = new Date();	
		var date2 = sdf.parse("2019/05/01");
		var date3 = sdf.parse("2018/05/01");

		List<Date> list = new ArrayList<>();
		list.add(date1);
		list.add(date2);
		list.add(date3);

		//シャローコピー
		List<Date> shallow = list;

		//ディープコピー
		List<Date> deep = list.clone();

		//listの操作
		var date4 = sdf.parse("2020/05/01");
		list.set(1, date4);

		//それぞれの出力  
		System.out.println(shallow);
		System.out.println(deep);

	}
}