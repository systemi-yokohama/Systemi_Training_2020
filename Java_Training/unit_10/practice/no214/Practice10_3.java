package Java_Training.unit_10.practice.no214;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.*;

//import Java_Training.practice100.no214.ArrayList;
class Practice10_3_1{
//①
@FunctionalInterface
public interface Hoge{
	void print(String str);
 }
}
class Practice10_3_2{

	@FunctionalInterface
	public interface Foo<T,R>{
		R process(T v1 ,T v2);
	}

}
class Practice10_3_3{
	public void practice(){ 
	var data=new ArrayList<String>(
	Arrays.asList("ABCDE","OP","WXYZ","HIJKL"));
    data.removeIf(v->v.length()>=3);
      data.replaceAll(v->{
     	if(v.length()<3){
	    	return v;
    	}else{
		    return v.substring(0,3);
	    }
     });
    System.out.println(data);
   }
}

class Practice10_3_4{
	public void main (String[] args){

	var list2 = new ArrayList<String>(Arrays.asList("シュークリーム","プリン","マドレーヌ","ババロア"));
	list2.stream().sorted((str1,str2)->str2.length()-str1.length());
	list2.forEach(System.out::println);
	}
}

class Practice10_3_5{
	public void main(String[] args) {
	var summary =IntStream.of(60,95,75,80,70)
    .collect(
	IntSummaryStatistics::new,
	IntSummaryStatistics::accept,
	IntSummaryStatistics::combine
);
System.out.println("最高点:" + summary.getMax()+"点");
System.out.println("平均点:" + summary.getAverage()+"点");
}
}
