[1]
import Java_Training.unit_05.practice.no212.util.regax.Pattern;

var str = "住所は〒160-0000　新宿区南町0-0-0です。￥nあなたの住所は〒210-9999　川崎市北町1-1-1ですね";
var ptn = Pattern.compile("￥￥d{3}-￥￥d{4}");
var match = ptn.matcher(str);
while(match.find()){
	System.out.println(match.group());
}
[2]
var str = "お問い合わせはsupport@example.comまで";
System.out.println(str.replaceAll(
	"[a-z0-9.!#$%&'*+/=?^_{|}~-]"
));