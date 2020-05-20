package Java_Training.practice100.no217;

public class No022 {
    public static void main(String[] args) {
        int argument = args.length;

        if (argument == 3) {
            listNames(args[0],args[1]);
        } else if(argument == 5) {
            listNames(args[1],args[2],args[4]);
        } else if(argument == 7) {
            listNames(args[0],args[3],args[5],args[6]);
        } else {
            System.out.println("Usage:引数の数を3,5,7のいずれにしてください");
            System.exit(2);
        }
    }

    private static void listNames(String... names){
        for(String name:names){
            System.out.println(name);
        }
    }
}