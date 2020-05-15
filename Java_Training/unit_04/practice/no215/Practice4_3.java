package Java_Training.unit_04.practice.no215;

public class Practice4_3 {
	public static void main(String[] args){
	int sum=0;

	for(int i=100; i<=200; i++){
		if(i%2==0){
			continue;
		}
		sum += i;
	}
	System.out.println("合計は"+sum+"です");
	}

	
}