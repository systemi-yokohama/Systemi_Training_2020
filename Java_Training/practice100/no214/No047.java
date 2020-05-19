package Java_Training.practice100.no214;
/*左から順に、4桁の西暦年、半角ハイフン、2桁の月、半角ハイフン、2桁の日、半角空白、2桁の時(24時制)、
半角コロン、2桁の分、半角コロン、2桁の秒、半角ピリオド、3桁のミリ秒、
のフォーマットで引数に指定されたjava.util.Date型が示す日時をローカル時間でフォーマットした文字列を
返却するユーティリティメソッドを持つクラスFormatUtilを実装せよ。
引数がnullの場合、nullを返却するものとする。 */
//2020-22-22 22:22:22.222
import java.time.LocalDateTime;
import java.util.Locale;

public class FormatUtil{
	public void main(String[] args){
		FormatUtil formatUtil=new FormatUtil(LocalDateTime.now());
		FormatUtil.keisan(formatUtil);
	}
	public String keisan( int data){
		if (data==null){

			return null;
		}

	       final FormatUtil data=new data("yyyy-MM-dd HH:mm:ss.SSS");
	       return data;	
	}
}	


	