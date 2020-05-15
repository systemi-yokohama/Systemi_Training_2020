/* 文字列の比較に==が使われている */

package Java_Training.practice100.no213.no063;

public class No063 {
	public int check1(String target) {
		if (target.equals("value1")) {
			return 0;
		} else if (target.equals("value2")) {
			return 1;
		}
		return 2;
	}
}