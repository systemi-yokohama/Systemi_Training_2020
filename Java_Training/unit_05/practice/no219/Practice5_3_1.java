package Java_Training.unit_05.practice.no219;
import java.time.LocalDateTime;
public class Practice5_3_1 {
	public static void main(String[] args) {
		var data=LocalDateTime.now();
		System.out.println(data.getMonthValue()+"月");
		System.out.println(data.getMinute()+"分");
	}
}