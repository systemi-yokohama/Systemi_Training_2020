package Java_Training.practice100.no211;

import java.util.stream.IntStream;

public class No054 {
	public static void main(String[] args) {
		/*
		int sum = 0;

		for(var i = 1; i <= 100; i++){
			if(i % 2 != 0){
				continue;
			}
			sum += i;
		}		

		System.out.println("偶数の合計は" + sum);
		*/


		//→
		System.out.println(IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).sum());
	}
}