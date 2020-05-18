/*
[1]
while:ループの先頭で条件式を判定する(前置判定)
do..,while:ループの末尾で判定する(後置判定)
*/

//[2]
package Java_Training.unit_04.practice.no211;

public class Practice4_2 {
	public static void main(String[] args){
		for(var i=1; i<=9; i++){
			for(var a=1; a<=9; a++){
				System.out.print(i * a + " ");
			}
			System.out.println();
		}
	}
}