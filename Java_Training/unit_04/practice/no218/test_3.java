package Java_Training.unit_04.practice.no218;


public class test_3 {
	public static void main(String[] args){
		int sum = 0;
		for(int i = 100;i <= 200;i++){
			if(i % 2 == 0){
			  continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}
	
}