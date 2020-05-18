package Java_Training.practice100.no211;

public class No054 {
	public static void main(String[] args) {
		int sum = 0;

		for(var i = 1; i <= 100; i++){
			if(i % 2 != 0){
				continue;
			}
			sum += i;
		}

		System.out.println("偶数の合計は" + sum);
	}
}