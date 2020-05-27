package Java_Training.practice100.no214;
//java.util.Date型の要素を持つリストについて、
//シャローコピーとディープコピーを行うユーティリティメソッドを実装せよ。
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Date;
//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;


public class No037 {
	
	public static void main(String[] args){
		var data1=String.valueOf(LocalDateTime.of( 2020, 22,22, 22, 22, 22));
		var data2=String.valueOf(LocalDateTime.of(2020, 11, 11, 11, 11,11));
		
		var list=new StringBuilder[]{
			new StringBuilder(data1),
			new StringBuilder(data2)
		};
		
	
		var list2=Arrays.copyOf(list,list.length);

		System.out.println(list2);
	
	     var listB=new StringBuilder[list.length];
	          for(var i=0;i<list.length;i++){

		listB[i]=new StringBuilder(list[i].toString());

	
	}
}
}