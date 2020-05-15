[1]
var str = "プログラミング言語";
System.out.println(str.substring(4,7));

[2]
var str5 = "鈴木￥t太郎￥t男￥t50歳￥t広島県";
var result5 = str5.split("￥t");
System.out.println(String.join("&",result5));