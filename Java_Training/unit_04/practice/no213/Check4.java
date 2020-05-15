/* [1]
	1.for
	2.args
	3.value
	4.i */

package Java_Training.unit_04.practice.no213;

public class Check4 {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		int total = 0;
		String language = "Scala";
		while(i <= 100) {
			sum += i;
			if(i > 1000) {
				break;
			}
			i++;
		}
		System.out.println("合計が1000を超えるのは、1～" + i + "を加算したときです。");

		for(int t = 100; t < 201; t++) {
			if(t % 2 == 0) {
				continue;
			}
			total += t;
		}
		System.out.println(total);

		switch(language) {
			case "Scala" :
			case "Kotlin" :
			case "Groovy" :
				System.out.println("JVM言語");
				break;
			case "C#" :
			case "Visual Basic" :
			case "F#" :
				System.out.println(".NET言語");
				break;
			default :
				System.out.println("不明");
				break;
		}

		if(language == "Scala" || language == "Kotlin" || language == "Groovy") {
			System.out.println("JVM言語");
		} else if (language == "C#" || language == "Visual Basic" || language == "F#") {
			System.out.println(".NET言語");
		} else {
			System.out.println("不明");
		}
	}
}