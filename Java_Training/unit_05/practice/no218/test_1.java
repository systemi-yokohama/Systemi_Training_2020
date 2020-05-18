package Java_Training.unit_05.practice.no218;

import java.time.Duration;
import java.time.Period;
import java.time.LocalDateTime;

public class test_1 {
	public static void main(String[] args){

		//①
		System.out.print("①:");
		var str1 = "となりのきゃくはよくきゃくくうきゃくだ";
		System.out.println(str1.lastIndexOf("きゃく"));

		//②
		System.out.print("②:");
		var str2 = "千葉";
		double tem= 17.256;
		System.out.println(String.format("%sの気温は、%.2fです",str2,tem));

		//③
		System.out.print("③:");
		var str3 = "彼女の名前は、花子です。";
		System.out.println(str3.replace("彼女","妻"));

		//④
		System.out.print("④:");
		var nt = LocalDateTime.now();
		var tt = Duration.parse("PD5T6H");
		System.out.println(nt.plus(tt));
		
		//⑤
		System.out.print("⑤:");
		var da1 = LocalDateTime.of(2020, 3, 12);
		var da2 = LocalDateTime.of(2020, 11, 5);
		var period = Period.between(da1, da2);
		System.out.println("差:" + period.getMonths() + "カ月" +  period.getDays() + "日");


	}

	 
	
}