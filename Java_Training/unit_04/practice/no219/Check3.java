package Java_Training.unit_04.practice.no219;

public class Check3 {
	public static void main(String[] args) {
		var sum=0;
		for (var i=100;i<200;i++){
			if(i%2==0){
				continue;
			}else{
				sum+=i;
			}

		}
		System.out.println(sum);
		
	}
}