package Java_Training.practice100.no215;

public class no022 {
	public static void main(String[] args) {
		public int number(int... values){
			if(values.length == 3){
				list(values[0],values[1]);
			}else if(values.length == 5){
				list(values[1],values[2],values[4]);
			}else if(values.length == 7){
				list(values[0],values[3],values[5],values[6]);
			}else{
				System.out.println("usage");
			}
		}	
	}
	public static void list(int... n){
		System.out.println(n);
	}
}
