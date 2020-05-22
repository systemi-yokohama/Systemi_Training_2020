package Java_Training.practice100.no211;
import java.util.Date;


public class No049{
	/*
	public Date date;
	public No049(){
	}

	public <Date> Date randDate(){
		var now = LocalDateTime.now();
		this.date = now.plus(Math.random(-86400, 86400), ChronoUnit.SECONDS);

		return this.date;
	}
	*/


	//→
	public static void main(final String[] args){
        
        // 現在日付から±1日のランダムな日時を取得.
        final Date randomDate = new DateUtil().randomDayAndTime();
        
        // 取得した日時を標準出力.
		System.out.println(randomDate);
	}

}