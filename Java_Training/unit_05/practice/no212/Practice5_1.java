package Java_Training.unit_05.practice.no212;

①
var str = "となりのきゃくはよくきゃくくうきゃくだ";
System.out.println(str.lastIndexOf("きゃく"));
②
System.out.println(String.format("%sの気温は、%.2fです。","千葉","17.256"));
③
var intro = "彼女は名前は花子です。";
System.out.println(intro.replace("彼女","妻"));
④
var dt = LocalDateTime.now();
System.out.println(dt.plus(Duration.parse("P5DT6H")));
⑤
var dt1 = LocalDate.of(2020,3,12);
var dt2 = LocalDate.of(2020,11,5);
var period = Period.between(dt1,dt2);
System.out.println("差=" + period.getMonths() + "ヶ月" + period.getDays() + "日間");