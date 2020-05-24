package Java_Training.practice100.no220.no062;
import java.util.*;

public class No062 {
	public static void main(String[] args) {

		// データは、キーバリュー形式で管理し、最大100個格納できる(＝登録できるキーの数が最大100個)
		Map<String, String> cashmap = Collections.synchronizedMap(new LinkedHashMap<String, String>(100));

		// メソッドの呼び出し
		firstPut(cashmap);
		System.out.println("----------------------------------------------------");
		firstInsert(cashmap);
		System.out.println("----------------------------------------------------");
		getData(cashmap);
		System.out.println("----------------------------------------------------");
		overRemove(cashmap);
		System.out.println("----------------------------------------------------");
	}

	// キーと値の追加
	public static void firstPut(Map<String, String> put) {
		put.put("key1", "value1");
		put.put("key2", "value2");
		put.put("key3", "value3");
		System.out.println("キーと値の追加");
		System.out.println(put);
	}
	
	// すでに挿入されているものと同じキーでデータを挿入した場合は、既存のデータを上書きする。
	public static void firstInsert(Map<String, String> insert) {
		insert.put("key1", "上書き");
		System.out.println("既存のデータを上書き");
		System.out.println(insert);
	}
	
	// 任意のタイミングでデータの挿入・取得ができる。
	// 同じデータを２回以上取り出すこともできる。
	// 単純な挿入・取得処理では、入れたデータは消えない。
	public static void getData(Map<String, String> get) {
		get.put("key4", "value4");
		get.get("key1");
		get.get("key1");
		get.get("key2");
		get.get("key2");
		System.out.println("データの挿入・取得");
		System.out.println(get);
	}

	// 101個目に相当するデータを挿入した場合は、"最も長く利用されていないもの"を削除した上で挿入する。
	public static void overRemove(Map<String, String> map) {
		map.clear();
		System.out.println("最も長く利用されていないものを削除した上で挿入");
		for(int i = 0; i < 100; i++) {
			map.put("key" + i, "value" + i + '\n');
		}
		System.out.println(map);
		map.put("key100", "value100");
		if(map.size() < 100) {
			System.out.println("要素数：" + map.size());
		} else {
			map.remove("key0");
			System.out.println("要素数：" + map.size());
		}
	}
}
