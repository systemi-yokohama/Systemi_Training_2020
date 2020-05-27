package Java_Training.practice100.no218.no54;

public class No54 {
	public static void main(String[] args){
		int sum = 0;
		for(int i = 1;i <= 100;i++){
			if(i % 2 == 0){
				sum += i;

			}
		}
		System.out.println(sum);
	}
	
}