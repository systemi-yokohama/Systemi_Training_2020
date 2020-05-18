package Java_Training.practice100.no211;
import java.util.ArrayList;

public class No022 {

	public ArrayList usage(String... strs){
		var count = 0;
		var list = new ArrayList<String>(4);
		for(var str : strs){
			count += 1;
		}

		if(count == 3){
			list.add(strs[0]);
			list.add(strs[1]);
		}
		else if(count == 5){
			list.add(strs[1]);
			list.add(strs[2]);
			list.add(strs[4]);
		}
		else if(count == 7){
			list.add(strs[0]);
			list.add(strs[3]);
			list.add(strs[5]);
			list.add(strs[6]);
		}
		else{
			list.add("usage");
		}

		return list;
	}

	public static void main(String[] args) {
		var list = usage("a","b","c");
		for(var str : list){
			System.out.println(str);
		}
	}

}