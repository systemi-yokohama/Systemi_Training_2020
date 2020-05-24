/*
シャローコピーとディープコピー
・java.util.Date型の要素を持つリストについて、
シャローコピーとディープコピーを行うユーティリティメソッドを実装
*/

package Java_Training.practice100.no212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class No037 {
    public static void main(Date[] arguments) {
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(new Date());
		dateList.add(new Date());
		
		ArrayList<Date> list2 = new ArrayList<>(dataList);
		ArrayList<Date> list3 = (ArrayList<Date>) dataList.clone();
		ArrayList<Date> list4 = new ArrayList<>();
		ArrayList<Date> list5 = list4;
	}
}