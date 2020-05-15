package Java_Training.unit_04.practice.no211;

public class Check3 {
	public static void main(String[] args) {
		int sum = 0;

		for(var i = 100; i <= 200; i++){
			if(i % 2 == 0){
				continue;
			}
			sum += i;
		}

		System.out.println("100~200の奇数の合計値は" + sum );
	}
}