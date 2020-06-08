package Java_Training.practice100.no211;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class No032 {

	@Target(ElementType.FIELD)
	public @interface Divisible3{
		if(args[0]%3 == 0){
			String divis = "3で割り切れます";
		}
		else{
			String divis = "3で割り切れます";
		}
	}

	@Dinisible3(divis)	
	public static void main(String args[]){

		
	}

}	