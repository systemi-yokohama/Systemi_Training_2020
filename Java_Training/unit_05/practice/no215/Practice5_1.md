1.　  
var str="となりのきゃくはよくきゃくくうきゃくだ"
System.out.println(str.lastIndexOf("きゃく"));  
  
2.　  
System.out.println(String.format(
"%sの気温は%.2f℃です。","千葉","17.256"
));  
  
3.　  
var str="彼女の名前は花子です。";  
System.out.println(str.replace("彼女","妻"));  
  
4.　  
var d=localDateTime.now();
var duration=Duration.parse("P5D6H");

System.out.println(d.plus(duration));  

5.　  
var d1=LocalDateTime.now(2020,3,12);  
var d2=LocalDateTime.now(2020,11,5);
var period=Period.between(d1.toLocalDate(),d2.toLocalDate());
System.out.println(period.getMonths() + "ヵ月" + period.getDays() + "日間"); 