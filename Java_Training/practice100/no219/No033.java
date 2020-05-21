package Java_Training.practice100.no219;


import java.util.HashSet;
import java.util.ArrayList;

public class No033 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
   		arrayList.add(1);
    	arrayList.add(2);
    	arrayList.add(3);
    	arrayList.add(4);
    	arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(9);
		arrayList = new ArrayList<>(new HashSet<>(arrayList));
		
        for (int i=0;i<arrayList.size();i++){
			if(arrayList.get(i)%2==1){
				System.out.println(arrayList.get(i));
			}else{
				continue;
			}
		}
    }

    
}
