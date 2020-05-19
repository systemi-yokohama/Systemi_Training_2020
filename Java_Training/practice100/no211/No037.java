package Java_Training.practice100.no211;
import java.util.Arrays;
import java.util.Date;

public final class No037 {
	public static void main(String[] args) {
		var list = new Date[]{
		};

		//shallow
		var listS = Arrays.copyOf(list, list.length);

		//deep
		var listD = new Date[list.length];
		for(var i = 0; i < list.length; i++){
			listD[i] = new Date(list[i].toString());
		}
		
	}
	//??????????
}