package Java_Training.unit_10.practice.no212;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice10_3 {
	public static void main(String[] args) {
//①
@FunctionalInterface
public interface Hoge{
	void print(String str);
}

//②
@FunctionalInterface
public interface Foo<T,R>{
	R process(T v1,T v2);
}

//③
var list = new ArrayList<String>(
	Arrays.asList("ABCDE","OP","WXYZ","HIJKL"));
list.replaceAll(v -> {
	if(v.length() < 3){
		return v;
	}else{
		return v.substring(0,3);
	}
});

//④
Stream.of("シュークリーム","プリン","マドレーヌ","ババロア")
.sorted((str1,str2) -> str2.length() - str1.length())
.forEach(System.out::println);

//⑤
var list = new int[]{60,95,75,80,70};
System.out.println(IntStream.of(list).max().orElse(0));
System.out.println(IntStream.of(list).average().orElse(0));
	}
}