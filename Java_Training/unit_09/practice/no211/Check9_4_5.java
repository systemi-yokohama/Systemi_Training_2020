package Java_Training.unit_09.practice.no211;
import java.util.ArrayList;
import java.util.List;

public class Check9_4_5 {
	/*
	public static ArrayList newArrayList(<? extends Object>... objs){
		for(var v : objs){
			var list = new ArrayList<>();
			list.add(v);
		}
		return list;
	} 
	*/

	//→?????
	public static <T> ArrayList<T> newArrayList(T... data){
		return new ArrayList<T>(List.of(data));
	} 
}