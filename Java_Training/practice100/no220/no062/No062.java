package Java_Training.practice100.no220.no062;

import java.util.*;

public class No062 {
	public static void main(String[] args) {
		Map<String, String> map = Collections.synchronizedMap(new LinkedHashMap<String, String>());
		map.put("key1", "value1");
		map.put("key2", "value3");
		map.put("key3", "value4");
		System.out.println(map);
		// すでに挿入されているものと同じキーでデータを挿入した場合は、既存のデータを上書きする。
		map.put("key1", "value2");
		System.out.println(map);
		
		// 任意のタイミングでデータの挿入・取得ができる。
		map.put("key4", "value5");
		System.out.println(map);
		// 同じデータを２回以上取り出すこともできる。
		System.out.println(map.get("key1"));
		System.out.println(map.get("key1"));
		
		for (int i = 0; i < 100; i++) {
			map.put("key" + i, "value" + i + "\n");
		}
		System.out.println(map);
		
		// 単純な挿入・取得処理では、入れたデータは消えない。
		map.put("key100", "value100");
		System.out.println(map);
		System.out.println(map.get("key1"));

		
		System.out.println(map.size());
		
	}
}



// データは、キーバリュー形式で管理し、最大100個格納できる(＝登録できるキーの数が最大100個)
// 101個目に相当するデータを挿入した場合は、"最も長く利用されていないもの"を削除した上で挿入する。
// 一度格納したデータは、上記の個数の上限に達したことによる削除、または同じキーでデータを上書きしない限り、常に残り続ける。