package Java_Training.practice100.no213.no037;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class No037 {
	public static void main(String[] args) {
		List<Date> list = new ArrayList<Date>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = "2020/02/23";
		String str2 = "2019/04/05";
		String str3 = "1994/10/24";
		try {
			Date date1 = sdf.parse(str);
			Date date2 = sdf.parse(str2);
			Date date3 = sdf.parse(str3);
			list.add(date1);
			list.add(date2);
			list.add(date3);

		} catch (ParseException s) {
			s.printStackTrace();
		}

		List<Date> cp = list;
		ArrayList<Date> dcp = new ArrayList<>(list);

		System.out.println(cp);
		System.out.println(dcp);
	}
}