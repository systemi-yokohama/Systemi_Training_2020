package Java_Training.practice100.no218.no44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class No44 {
	public static void main(String[] args){

		List<Integer> date = new ArrayList<Integer>();

		Collections.sort(date,new java.util.Comparator<Integer>(){
		  @Override
		  public int compare(Integer i1,Integer i2){
			  return i2 - i1;
		  }
		});
		for(Integer a : date){
			System.out.println(a);
		}
	}
}