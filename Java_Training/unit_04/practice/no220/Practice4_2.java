package Java_Training.unit_04.practice.no220;

public class Practice4_2 {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		
		while(sum < 1000) {
			sum += i;
			i++;
		}
		System.out.println("合計が1000を超えるのは、1~" + i + "を加算したときです。");
	}
	}
