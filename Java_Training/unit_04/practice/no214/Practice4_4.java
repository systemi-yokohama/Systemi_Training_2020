package Java_Training.unit_04.practice.no214;
/*switch文でコードを作成 */
public class Practice4_4 {
	public static void main(String[] args) {
		//何かしら入れないと後の変数languageに赤線が入るのでC#を仮に代入
	String language ="C#";  
	
	switch( language ){
		case "Scala":
		case "Kotlin":
		case "Goovy" :
		  System.out.println("JVM言語") ;
		  break;
		case "C#":
		case "Visjal Bacsic":
		case "F#":
		  System.out.println(".NET言語");
		  break;
		default :
		  System.out.println("不明");
		  break;
		  
	}
	}
}
