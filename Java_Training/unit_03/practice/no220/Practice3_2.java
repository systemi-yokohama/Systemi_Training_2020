// x = 6
// y = 4
// builder1 = いろはにほへと
// builder2 = いろはにほへと

package Java_Training.unit_03.practice.no220;

public class Practice3_2 {
	public static void main(String[] args){
	var x = 6;
	var y = x;
	y -= 2;
	System.out.println(x);
	System.out.println(y);

	var builder1 = new StringBuilder("いろは");
	var builder2 = builder1;
	builder1.append("にほへと");
	System.out.println(builder1);
	System.out.println(builder2);
	}
}