package Java_Training.unit_06.practice.no210;
import java.util.HashMap;

public class Practice6_2 {
	public static void main(String[] args) {
		//mapの定義
		var map = new HashMap<String, String>() {
			{
				put("cucumber", "キュウリ");
				put("lettuce", "レタス");
				put("spinach", "ホウレンソウ");
			}
		};

		//mapの操作
		map.put("carrot", "ニンジン");
		map.remove("spinach");
		map.replace("cucumber", "胡瓜");

		//mapの出力
		for(var entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}