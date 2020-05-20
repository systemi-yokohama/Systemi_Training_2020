package Java_Training.practice100.no219.test;

public class Test {
	public static void main(String[] arguments) {
        try {
            try {
                throw new Exception("1st");
            } finally {
                throw new Exception("2nd");
            }
        } catch (Exception happened) {
            System.out.println(happened.getMessage());
        }
    }
}