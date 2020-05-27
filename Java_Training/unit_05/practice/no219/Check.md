1.1 var str ="となりのきゃくはよくきゃくくうきゃくだ";
    System.out.println(str.lastIndexOf "きゃく");
1.2 var locale="千葉";
    var temp=17.256;
    System.out.println(String.format"%sの気温は、%.2fです。",locale,temp);
1.3 var intro ="彼女の名前は花子です。" 
    System.out.println(intro.replace("彼女","妻"))
1.4 var date=LocalDateTime.now();
    System.out.println(date.plus(Duration.parse("P5DT6H")));
1.5 var date1=LocalDate.of(2020,3,12);
    var date2=LocalDate.of(2020,11,5);
    var period=Period.between(date1,date2);
    System.out.println("日付の差："+period.getMonths()+"ヶ月"+ +period.getDays()+"日間");

2.1 java.util.regex.Pattern
2.2 try
2.3 Paths.get
2.4 readLine()
2.5 matcher
2.6 line
2.7 group()
4.1 System.out.println(Math.pow(6,3));
4.2 System.out.println(Math.abs(-15));
4.3 var data=new int[]{110,14,28,32};
    Arrays.sort(data);
    System.out.println(Arrays.toString(data));