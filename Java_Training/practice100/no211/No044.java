package Java_Training.practice100.no211;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class No044 implements Comparable<No044>{
	
	//→
	private Date day;

	No044(Date day) {
       	this.day = day;
	}
	
	/*
	public static <T> void main(String[] args) {
		var d1 = new Date();
		var d2 = new Date(2020, 10, 1);
		var d3 = new Date(2020, 3, 1);

		List<Date> list = new ArrayList<Date>(Arrays.asList(d1, d2, d3));

		Collections.sort(list);
		
	}*/


	//→
	public static void main(final String[] args) {
        /* Dateリスト. */
        final List<No044> dateList = new ArrayList<No044>();
        
        /* リストへDateインスタンスを保有するオブジェクトを格納. */
        dateList.add(new No044(new Date()));
        dateList.add(new No044(new Date(1476423938529L)));
        dateList.add(new No044(new Date(1421453545000L)));
        dateList.add(new No044(null));
        
        // nullが混在していた場合、エラーを出力する.
        try {
            System.out.println("ソート前");
            
            // ソート前のDateリストの日時を標準出力する.
            for (No044 date : dateList) {
                System.out.println(date.day);
            }
            
            // ソートを行う.
            Collections.sort(dateList);
            
            System.out.println("\nソート後");
            
            // ソート後のDateリストの日時を標準出力する.
            for (No044 date : dateList) {
                System.out.println(date.day);
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Dateインスタンスが保有する日時を比較し、
     * 日時の昇順ソートを行う.
     *
     * @param object Answer044オブジェクト
     * @return Date型インスタンスの日時比較結果
     * @exception NullPointerException objectがnullの場合.
     */
    @Override
    public int compareTo(No044 object) {
        No044 dayInstance = object;
        
        if (this.day == null && dayInstance.day == null) {
            return 0;
        } else if (this.day == null) {
            return -1;
        } else if (dayInstance.day == null) {
            return 1;
        } else {
            return this.day.compareTo(dayInstance.day);
        }
    }
}