### 第五章  理解度チェック                  
1. String/LocalDateTimeクラスの利用     
    Practice5_4_1_(1~5).java
2. メールアドレスの一覧表示穴埋め   
  1. java.utill.regex.Pattern   
  2. try    
  3. paths.get    
  4. readLine()   
  5. matcher    
  6. line   
  7. group()    
3. MathクラスとArrayクラスの利用    
  ```
  import java.util.Arrays;

  public class Practice5_4_7 {
    public static void main(String[] args){
      var list = new int[] {110,14,28,32};
      Arrays.sort(list);
      // 4-1
      System.out.println(Math.pow(6,3));
      // 4-2
      System.out.println(Math.abs(-15));
      //4-3
      System.out.println(Arrays.toString(list));	
    }
  }
  ```