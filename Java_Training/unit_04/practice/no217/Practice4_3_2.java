package Java_Training.unit_04.practice.no217;

public class Practice4_3_2 {
	public static void main(String[] args) {
		var language = "";
		if(language == "Scala" || language == "Kotlin" || language == "Groovy"){
		System.out.println("JVM言語"); 
		} else if (language == "C#" || language == "Visuale Basic" || language == "F#"){
			System.out.println(".NET言語");
		} else {
			System.out.println("不明");
		}
	}
	
}