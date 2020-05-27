package Java_Training.practice100.no215;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class no037 {
	private  List<Date> dateList = new ArrayList<Date>();

	public static void main( String[] args) throws ParseException, CloneNotSupportedException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		 Date past = sdf.parse("2010/10/10");
		 Date future = sdf.parse("2030/01/01");
		 Date today = new Date();

		// インスタンスを生成（コピー元）.
		 no037 dateInstance = new no037();

		dateInstance.dateList.add(past);
		dateInstance.dateList.add(today);
		dateInstance.dateList.add(future);

		no037 deepCopyDateInstance = (no037) dateInstance.clone();

		List<Date> shallowDateList = shallowCopy(dateInstance.dateList);

		// ディープコピーデータの標準出力.
        if (deepCopyDateInstance == null) {
            System.out.println(deepCopyDateInstance);
        } else {
            System.out.println(deepCopyDateInstance.dateList.get(0));
        }
        
        // シャローコピーデータの標準出力.
        if (shallowDateList == null) {
            System.out.println(shallowDateList);
        } else {
            System.out.println(shallowDateList.get(0));
        }


	}

	private static List<Date> shallowCopy(List<Date> dateList2) {
		return null;
	}

	
		
	


}