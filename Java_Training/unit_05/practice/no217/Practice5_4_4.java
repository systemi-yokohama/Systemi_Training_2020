package Java_Training.unit_05.practice.no217;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Practice5_4_4 {
	public static void main(String[] args){
		LocalDateTime date1 = LocalDateTime.now();	
		date1 = date1.plusDays(5); 
		date1 = date1.plusHours(6); 
		DateTimeFormatter format1 = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		String fdate1 = format1.format(date1);
		System.out.println(fdate1);
	}
}

// import java.util.Calendar;
// import java.util.Date;
// import java.text.SimpleDateFormat;
 
// public class Practice5_4_4 {
//     public static void main(String[] args) {
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//         Date date = new Date();
//         Calendar calendar = Calendar.getInstance();
//         calendar.setTime(date);
//         calendar.add(Calendar.DAY_OF_MONTH, 5);
//         calendar.add(Calendar.HOUR, 6);
//         Date d1 = calendar.getTime();
//         System.out.println(sdf.format(d1));
//     }
 
// }