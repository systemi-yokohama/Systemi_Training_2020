package Java_Training.unit_04.practice.no219;

public class Check5 {
	public static void main(String[] args) {
		var language ="Scala";
		if (language=="Scala" ||language=="Kotlin"||language=="Groovy"){
			System.out.println("JVM言語");
		}else if(language=="C#"||language=="Visual Basic"||language=="F#"){
			System.out.println(".NET言語");
		}else{
			System.out.println("不明");
		}


	}
}