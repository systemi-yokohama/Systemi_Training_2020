package Java_Training.unit_05.practice.no213;

import java.util.regex.Pattern;

public class Practice5_2 {
	public static void main(String[] args) {
		var js = "住所は〒160-0000 新宿区南町0-0-0です。\n あなたの住所は〒210-9999 川崎市北町1-1-1ですね。";
		var ptn = Pattern.compile("\\d{3}-\\d{4}");
		var match = ptn.matcher(js);
		while(match.find()) {
			System.out.println(match.group());
		}
	}
}

public class mail () {
	public static void main(String[] args) {
		var str = "お問い合わせはsupport@example.comまで";
		var ptn = Pattern.compile(str.replaceAll("[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9-]+(?:\\.[a-z0-9-]+)*", "<a href=\"mailto:$0\">$0</a>"));
	}
}