package Java_Training.unit_04.practice.no214;
/*4_4のコードをif文で書き換える */
public class Practice4_5 {
	
	public static void main(String[] args) {
		//何かしら入れないと後の変数languageに赤線が入るのでC#を仮に代入
	String language ="C#";  
	
	if( language == "Scala" || language == "Kotlin" || language == "Goovy" ){//JIM言語に該当する場合
		  System.out.println("JVM言語") ;
	}else if(  language == "C#" || language == "Visjal Bacsic" || language == "F#" ){//.NET言語に該当する場合
	
		  System.out.println(".NET言語");
	}else{
		System.out.println("不明");
	}
		
		
		  
	}
	}
