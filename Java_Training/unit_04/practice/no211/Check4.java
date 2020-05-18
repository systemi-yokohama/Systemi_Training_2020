package Java_Training.unit_04.practice.no211;

public class Check4 {
	public static void main(String[] args) {
		String language = "Scala";

		switch(language){
			case "Scala":
			case "Kotlin":
			case "Groovy":
				System.out.println("JVM言語");
				break;
			case "C#":
			case "Visual Basic":
			case "F#":
				System.out.println(".NET言語");
			default:
				System.out.println("不明");
		}
		
	}
}