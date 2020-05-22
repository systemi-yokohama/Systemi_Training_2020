package Java_Training.unit_10.practice.no214;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

import Java_Training.practice100.no212.ArrayList;

//①
@FunctionalInterface
public interface Hoge{
	void print(Stirng str);
}
//②
@FunctionalInterface
public interface Foo<T,R>{
	R process(T v1,v2);
}
//③
var data=new ArrayList<String>(
	Arrays.aslist("ABCDE","OP","WXYZ","HIJKL"));
data.removeIf(v->v.length()>=3);
data.replaceAll(v->{
	if(v.length()<3){
		return v;
	}else{
		return v substirng(0,3);
	}
});
System.out.println(data);
//④
Stream.of("シュークリーム","プリン","マドレーヌ","ババロア")
.sorted((str1,str2)->str2.length()-str1.length())
.forEach(System.out::println);

//⑤
var summary =IntStream.of(60,95,75,80,70)
.collect(
	IntSummaryStatistics::new,
	IntSummaryStatistics::accept,
	IntSummaryStatistics::combine
);
System.out.println("最高点:" + summary.getMax()+"点");
System.out.println("平均点:" + summary.getAverage()+"点");
