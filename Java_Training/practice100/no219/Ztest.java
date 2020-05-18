package Java_Training.practice100.no219;

public class Ztest {
	public static void main(String[] arguments) {
        String s1 = "hoge";
        String s2 = "ho" + "ge";
        String s3 = new String(s1);
        String s4 = new String(s1).intern();
        printDifference(s1, s2);
        printDifference(s1, s3);
        printDifference(s1, s4);
    }
    
    private static void printDifference(String a, String b) {
        System.out.println(
              (a == b)
            + ":"
            + a.equals(b)
            + ":"
            + ((a.hashCode() == b.hashCode()))
        );
    }
}