package Java_Training.unit_09.practice.no214;


public class Practice9_4_2{
	public enum Weekday{
		MONDAY,
		TUESDAY;

	}
	public static void main(String[] args){
		var day=Weekday.valueOf("Monday");//名前から列挙定数を取得

			System.out.println(day instanceof Weekday);//s instanceof 名前で型確認
	
	}
}
		
