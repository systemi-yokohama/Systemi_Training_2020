package Java_Training.practice100.no220.no022;

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
                System.out.println("Usage");
                System.exit(2);
            }
        }
        private static void listNames(String... names){
            for(String name:names){
                System.out.println(name);

		// switch (args.length) {
        //     case 3:
        //         showArgument(args[0], args[1]);
        //         break;
        //     case 5:
        //         showArgument(args[1], args[2], args[4]);
        //         break;
        //     case 7:
        //         showArgument(args[0], args[3], args[5], args[6]);
        //         break;
        //     default:
        //         System.out.println("Usage");
        //         System.exit(2);
        //         break;
        // }


		// }


		// public static void showArgument(String... items) {
		// 	for (String item : items) {
		// 		System.out.println(item);
		// 	}
		// }
    }
    }
}