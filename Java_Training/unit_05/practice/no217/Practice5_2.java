package Java_Training.unit_05.practice.no217;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice5_2 {
	public static void main(String[] args){
		// 1.正規表現検索①		
		String address = "住所は〒160-0000 新宿区南町 0-0-0です。\nあなたの住所は〒210-9999 川崎市北町1-1-1ですね";
		Pattern p = Pattern.compile("[0-9]{3}-[0-9]{4}");
        Matcher m = p.matcher(address);
 
        while (m.find()) {
			System.out.println(m.group());
			
		// 2.正規表現検索②		
		
        }
	}
}