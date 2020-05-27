package Java_Training.practice100.no215;

public class no022 {
	public static void main(final String[] args) {
		final int values=args.length;
			if(values == 3){
				list(args[0],args[1]);
			}else if(values == 5){
				list(args[1],args[2],args[4]);
			}else if(values == 7){
				list(args[0],args[3],args[5],args[6]);
			}else{
				System.out.println("usage");
			}
		
	}


	public static void list(final String... s) {
		System.out.println(s);
	}
}
