package Java_Training.practice100.no217;

public class No015 {
    private String name;
    No015(){
        this("no_name");
    }
    No015(final String name) {
        this.name = name;
    }
	public static void main(String[] args) {
        System.out.println(new No015("Maeda Kaito").name);
        System.out.println(new No015().name);
    }
}