1. 
public interface Hoge{
    void printf(String str);
}

2. 
public interface Foo{
    R process(T v1,T v2);
}

3. 
var list =new ArrayList<String>(
    Arrays.aslist("ABCDE","OP","WXYZ","HIJKL")
);
list.replaceAll(v -> {
    if(v.length() > 3){
        return v;
    }else{
        return v.substring(0,3);
    }
});

4. 
Stream of("シュークリーム","プリン","マドレーヌ","ババロア")
    .sorted((str1,str2) -> str2.length()-str1.length())
    .forEach(System.out::println);

5. 
var list=new int[] {60,95,75,80,70};
System.out.println(IntStream.of(list),max(),orElse(0));
System.out.println(IntStream.of(list),average(),orElse(0));