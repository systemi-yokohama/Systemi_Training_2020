/* [1]
1.算術演算子
2.代入演算子
3.比較演算子
4.論理演算子
5.&, |, ^, >>

[2]
x = 6
y = 4
builder1 = いろはにほへと
builder2 = いろはにほへと

[3]
nullチェックをしていないから */

package Java_Training.unit_03.practice.no213;

public class Check3 {
    public static void main(String[] args) {
        String str = null;
        if(str != null && str.endsWith(".java")) {
            System.out.println("拡張子は.javaです。");
        }
    }
}