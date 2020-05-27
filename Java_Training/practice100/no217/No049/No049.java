package Java_Training.practice100.no217.No049;

import java.util.Date;

/**
 * 049の解答です。
 *
 * @author jsfkdt
 */
public class No049 {
    public static void main(final String[] args) {
        
        // 現在日付から±1日のランダムな日時を取得.
        final Date randomDate = new No049_2().randomDayAndTime();
        
        // 取得した日時を標準出力.
        System.out.println(randomDate);
    }
}