package Java_Training.practice100.no214;

class Main {
	public static void main(String[] args) {
	  int sum=0;
		 for(int i=0;i<=100;i++){
			  if( 0==i%2 ){
				  sum+=i;
			  }
			  
		  }
	  System.out.println("1から100までの整数に含まれる偶数の合計は" + sum + "です");
	}
  }
  