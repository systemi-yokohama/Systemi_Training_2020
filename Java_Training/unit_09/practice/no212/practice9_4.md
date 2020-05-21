①
<br>public class Person{
<br>    public String firstName;
<br>  public String lastName;

    @Override
    public String toString(){
        return String.format("Person:%s%s",this.lastName,this.firstName);
    }
}

②
var day = Weekdey.valueOf("Monday");
System.out.println(day instanceof Weekday);

③マルチキャッチを活用<br>
<br>try{
<br>    ...   ...
<br>}catch(IOException | SQLException e){
<br>    ...   ...
<br>}

④
<br>public class Main{
<br>    private static class Sub{
<br>        ...   ...
<br>    }
<br>}

⑤
<br>public static <T> ArrayList<T> newArrayList(T...){
<br>    return new ArrayList<>(...);
<br>}