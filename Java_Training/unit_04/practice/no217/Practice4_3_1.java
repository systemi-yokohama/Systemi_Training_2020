package Java_Training.unit_04.practice.no217;

public class Practice4_3_1 {
	public static void main(String[] args) {
	var language = "---";
    switch(language) {
        case "Scala":
        case "Kotlin":
        case "Groovy":
            System.out.println("JVM言語");
            break;
        case "C#":
        case "Visuale Basic":
        case "F#":
            System.out.println(".NET言語");
            break;
        default:
            System.out.println("不明");
    }
	}
	
}