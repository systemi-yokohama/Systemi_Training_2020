package Java_Training.unit_04.practice.no214;
/*for文、continueで100~200の範囲の奇数値の合計を求める */ 
public class Practice4_3 {
	public static void main(String[] args) {
	

		int sum=0;  
		for ( int i = 100 ; i <= 200 ; i++ ){  
		  if( i % 2 == 0 ){  
			  continue;  
		  } 
		  sum+=i;
		}  
		
		System.out.println("100~200の奇数値の合計は" + sum + "です");
		
		}
}