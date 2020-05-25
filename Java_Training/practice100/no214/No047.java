package Java_Training.practice100.no214;
/*左から順に、4桁の西暦年、半角ハイフン、2桁の月、半角ハイフン、2桁の日、半角空白、2桁の時(24時制)、
半角コロン、2桁の分、半角コロン、2桁の秒、半角ピリオド、3桁のミリ秒、
のフォーマットで引数に指定されたjava.util.Date型が示す日時をローカル時間でフォーマットした文字列を
返却するユーティリティメソッドを持つクラスFormatUtilを実装せよ。
引数がnullの場合、nullを返却するものとする。 */
//2020-22-22 22:22:22.222
import java.time.LocalDateTime;
import java.util.Locale;
import java.time.format.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

	class Main{
	public static void main(String[] args) {
		
	
		FormatUtil214  today=new FormatUtil214(LocalDateTime.now());
	
		System.out.println(FormatUtil214.tod(today));
	}
	}
	
	class FormatUtil214{
		public LocalDateTime today;

	   public FormatUtil214(LocalDateTime today){			
		this.today=today;	
	   }

	   public String tod(LocalDateTime today){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
        return fmt.format(today);
	   }
	}
	
