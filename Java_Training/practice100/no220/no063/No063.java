package Java_Training.practice100.no220.no063;

public class No063 {
	public static void main(String[] args) {
        System.out.println(check1("value1"));
        System.out.println(check2("value2"));
    }
    
    public static int check1(String target) {
        if (target == "value1") {
            return 0;
        } else if (target == "value2") {
            return 1;
        }
            return 2;
    }

    public static int check2(String target) {
        if (target.equals("value1")) {
            return 0;
        } else if (target.equals("value2")) {
            return 1;
        }
        return 2;
    }
}