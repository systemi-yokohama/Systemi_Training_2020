package Java_Training.practice100.no220.no022;

public class No022 {
    public static void main(String[] args) {
        // 配列の追加
        String[] a = {"a", "b", "c", "d", "e", "f", "g"};
        arrays(a);
    }    

    // 可変長引数の設定
    public static void arrays(String... array) {
    // 要素数に応じた処理
        switch (array.length) {
            case 3 :
            System.out.println(array[0] + "\n" + array[1]);
            break;
                        
            case 5 :
            System.out.println(array[1] + "\n" + array[2] + "\n" + array[4]);
            break;
                        
            case 7 :
            System.out.println(array[0] + "\n" + array[3] + "\n" + array[5] + "\n" + array[6]);
            break;
            
            default :
            System.out.println("Usage");
            break;
        }
    }
}
