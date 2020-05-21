package Java_Training.practice100.no220.no022;

public class No022 {
    
    // public static void main(String[] args) {
    //     int argument = args.length;
    //     if (argument == 3) {
    //         listNames(args[0],args[1]);
    //     } else if(argument == 5) {
    //         listNames(args[1],args[2],args[4]);
    //     } else if(argument == 7) {
    //         listNames(args[0],args[3],args[5],args[6]);
    //     } else {
    //         System.out.println("Usage:引数の数を3,5,7のいずれにしてください");
    //         System.exit(2);
    //     }
    // }
    // private static void listNames(String... names){
    //     for(String name:names){
    //         System.out.println(name);
    //     }
    // }

    
    public static void main(String[] args) {
        
        switch (str.length) {
            case 3 :
            System.out.println(str[0] + "\n" + str[1]);
            case 5 :
            System.out.println(str[1] + "\n" + str[2] + "\n" + str[4]);
            case 7 :
            System.out.println(str[0] + "\n" + str[3] + "\n" + str[5] + "\n" + str[6]);
            default :
            System.out.println("Usagi");
            break;
        }
    }
                    public void str(String... args) {
                        str("a", "b", "c");
                        str("a", "b", "c");
                        str("a", "b", "c");
}
}
