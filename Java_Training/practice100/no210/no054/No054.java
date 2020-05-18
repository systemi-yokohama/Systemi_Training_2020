package Java_Training.practice100.no210.no054;

public class No054 {
	public static void main(String args[]) {
		var sum = 0;

		for(var i = 1; i <= 100; i ++) {
			if(i % 2 != 0) {
				continue;
			}
			sum += i;
		}

		System.out.println("1~100の整数の偶数値を合計すると" + sum + "です。");
	}
}
