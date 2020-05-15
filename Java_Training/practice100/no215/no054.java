package Java_Training.practice100.no215;

public class no054 {
	public static void main(String[] args){
		int sum=0;
	
		for(int i=1; i<=100; i++){
			if(i%2!=0){
				continue;
			}
			sum += i;
		}
		System.out.println("合計は"+sum+"です");
	}	
	
}