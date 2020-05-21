package Java_Training.practice100.no220.no022;

public class No022 {

    public void str(String... args) {
        str("a");
        str("b");
        str("c");
}

    public static void main(String[] args) {

        switch (args.length) {
            case 3 :
            System.out.println(args[0] + "\n" + args[1]);
            case 5 :
            System.out.println(args[1] + "\n" + args[2] + "\n" + args[4]);
            case 7 :
            System.out.println(args[0] + "\n" + args[3] + "\n" + args[5] + "\n" + args[6]);
            default :
            System.out.println("Usagi");
            break;
        }
}
    }
