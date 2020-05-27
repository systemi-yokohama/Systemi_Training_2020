1.  ×   ×   〇  ×   ×   
2.  <T> <? super T> T...    add result
3.  implements Cloneable    @Override   Person  (Person)super.clone()   this.memos.clone()  CloneNotSupportedException
4.  public class Person{
        public String firstName;
        public String lastName;
        @Override
        public String toString(){
            return String.format("Person:%s %s",this.lastName,this.firstName);
        }
    }
------------------------------------
    var day =Weekday.valueOf("Monday");
    System.out.println(day instanceOf Weekday);
------------------------------------

    try{

    }catch(IOException|SQLException e){...}
------------------------------------

    public class Main{
        private static class Sub{}
    }
------------------------------------

    public static <T> ArrayList<T> newArrayList(T... data){
        return new ArrayList<T> (List.of(data));
    }