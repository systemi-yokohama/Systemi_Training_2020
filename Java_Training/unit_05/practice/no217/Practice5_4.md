### 第五章  理解度チェック                  
1. String/LocalDateTimeクラスの利用     
    1-1     
    ```
    var a = "となりのきゃくはよくきゃくくうきゃくだ";
		System.out.print(a.lastIndexOf("きゃく"));
    ```     
    1-2     
    ```
    var a = "千葉";
    var b = 17.256;
		String c = String.format("%sの気温は%.2f℃です。",a,b);
		System.out.println(c);
    ```     
    1-3     
    ```
    var a = "彼女の名前は花子です。";
		var b = a.replace("彼女","妻");
		System.out.println(b);
    ```     
    1-4     
    ```
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

    public class Practice5_4_4 {
      public static void main(String[] args){
        LocalDateTime date1 = LocalDateTime.now();	
        date1 = date1.plusDays(5); 
        date1 = date1.plusHours(6); 
        DateTimeFormatter format1 = 
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String fdate1 = format1.format(date1);
        System.out.println(fdate1);
      }
    }
    ```   
    1-5
    ```
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.time.temporal.ChronoUnit;

    public class Practice5_4_5 {
      public static void main(String[] args){
        LocalDate date1 = LocalDate.of(2020,03,12);	
        LocalDate date2 = LocalDate.of(2020,11,05);	
        
        DateTimeFormatter format1 = 
            DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fdate1 = format1.format(date1);
        DateTimeFormatter format2 = 
            DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fdate2 = format2.format(date2);

        long months = ChronoUnit.MONTHS.between(date1, date2);
        long day = ChronoUnit.DAYS.between(date1, date2);

        System.out.println(months + "ヶ月" + day + "日間");
      }
    }
    ```
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