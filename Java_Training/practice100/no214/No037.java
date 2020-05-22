package Java_Training.practice100.no214;
//java.util.Date型の要素を持つリストについて、
//シャローコピーとディープコピーを行うユーティリティメソッドを実装せよ。
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class No037 {
	
	public static void main(String[] args){
		var data1=String.valueOf(LocalDateTime.of( 2020, 22,22, 22, 22, 22));
		var data2=String.valueOf(LocalDateTime.of(2020, 11, 11, 11, 11,11));
		
		var list1=new StringBuilder[]{
			new StringBuilder(data1),
			new StringBuilder(data2)
		};
		No037 no037a=new No037();
		No037 no037b=new No037();
		no037a.shallow();
		no037b.deep();
	}
		public void shallow(){
		var list2=Arrays.copyOf(list1,list1.length);
		}

		public void deep(){
		var list3=new StringBuilder[list1.length];
		for(var i=0;i<list1.length;i++){
			list3[i]=new StringBuilder(list1[i].toString());
		}
	}

}
