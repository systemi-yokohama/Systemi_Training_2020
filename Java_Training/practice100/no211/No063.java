package Java_Training.practice100.no211;

/*## 063：複合(3)
* 以下のコードの問題点を指摘し、修正案を提示せよ。
*/

public class No063 {
    public int check1(String target) {
        if (target ==  "value1") {
            return 0;
        } else if (target == "value2") {
            return 1;
        }
        return 2;
    }
    //→文字列の比較は equals() メソッドを使う。

	
    public int check2(String target) {
        /*
        →targetがnullの場合NullPointerExceptionが発生
        してしまうため、(equalsというメソッドを使うから)
        先頭に
        if(target == null){
            return 2;
        }
        と書き足す。
        */
        if (target.equals("value1")) {
            return 0;
        } else if (target.equals("value2")) {
            return 1;
        }
        return 2;
	}
}