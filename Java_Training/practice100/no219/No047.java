package Java_Training.practice100.no219;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;



public class No047 {
	public static void main(String[] args) {
		var date=LocalDateTime.of(2020,05,12,15,10,10,712);
		if (date==null){
			System.out.println("null");
		}else{
			System.out.println(date.format(DateTimeFormatter.ofPattern("y-MM-dd H:m:s.S")));
		}
	}
}