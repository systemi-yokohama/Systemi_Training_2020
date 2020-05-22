package Java_Training.practice100.no211;
import java.util.ArrayList;

public class No033 {
	public static void main(String[] args) {
		var list = new ArrayList<Integer>();
		for(var i=0; i<=9; i++){
			list.add(i);
		}

		list.removeIf(v -> (v.intValue()%2==0));
		System.out.println(list);
	}
}

/*
→

.stream()                      // 処理用の Stream を生成
.filter(i -> i % 2 == 1)       // 奇数のみを Stream に残す
.forEach(System.out::println); // 残っている全要素に対し System.out.println(int) を実施
*/