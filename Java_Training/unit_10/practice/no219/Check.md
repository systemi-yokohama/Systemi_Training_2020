1.  ×   ×   ×   ×   ×   
2.  <T> Predicate<T> cond.test(value) result.add(value) v->v.length()>3
3.  @FunctionalInterface
    pubilc interface Hoge{
        void print(String str);
    }
    -------------------------------
    @FunctionalInterface
    public interface Foo<T,R>{
        R process(T v1,T v2):
    }
        -------------------------------
    var list =new ArrayList<String>(
        Arrays.asList("ABCDE","OP","WXYZ","HIJKL")
    );
    list.replaceAll(v ->{
        if (v.length()<3>){
            return v;
        }else{
            return v.substring(0,3);
        }
    });
        -------------------------------
    Stream.of("","","","")
        .sorted((str1,str2)->str2.length() -str1.length())
        .forEach(System.out::println);
        -------------------------------
    var list =new int[]{60,95,75,80,70};
    System.out.println(IntSteam.of(list).max().orElse(0));
    System.out.println(IntSteam.of(list).average().orElse);
    
