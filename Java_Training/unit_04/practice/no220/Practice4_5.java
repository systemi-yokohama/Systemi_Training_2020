package Java_Training.unit_04.practice.no220;

public class Practice4_5 {
	public static void main(String[] args) {
		String language = "F#";

		if(language == "Scala" || language == "Kotlin" || language == "Groovy") {
			System.out.println("JVM言語");
		} else if(language == "C#" || language == "Visual Basic" || language == "F#") {
			System.out.println(".NET言語");
		} else {
			System.out.println("不明");
		}
	}
}
