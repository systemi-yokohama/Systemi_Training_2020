package Java_Training.practice100.no210.no062;
import java.util.HashMap;

public class No062 {
	public static void main(String[] args) {
		var data = new HashMap<String, String>(100, 0.75F);
		
		//挿入
		data.put("key1", "value1");
		data.put("key2", "value2");
		data.put("key3", "value3");

		//上書き
		data.put("key1", "value4");
		data.replace("key1", "value1", "value4");

		//取得
		System.out.println(data.get("key2"));

		//101個目のデータ挿入
		if(data.size() == 100) {
			System.out.println("最も長く利用されていないデータを削除してください。");
		} 
	}
}