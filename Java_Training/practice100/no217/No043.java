package Java_Training.practice100.no217;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Cloneable;
import java.lang.InternalError;

public class No043 implements Cloneable{
	// Date型インスタンス 
	Date targetDay = new Date(1421453545000L);
	
	public static void main(final String[] args) {
		// インスタンスの生成.
        No043 no043 = new No043();
        
        // ディープコピーを行う.
        No043 deepCopyDateInstance = no043.clone();
        
        // 元データの書き換え
        no043.targetDay.setTime(1476423938529L);
        
        // ディープコピーデータの標準出力.
        if (deepCopyDateInstance == null) {
            System.out.println(deepCopyDateInstance);
        } else {
            // 書き換え前データのインスタンス生成時刻を出力.
            System.out.println("インスタンス生成時刻「"
                    + convertToTime(deepCopyDateInstance.targetDay) + "」");
        }
        
        // 書き換え後データの時刻を出力.
        System.out.println("書き換え後の時刻「"
                + convertToTime(no043.targetDay) + "」");
	}

	// オブジェクトのディープコピーを行い、コピー後オブジェクトを返却
	@Override
    public No043 clone() {
        try {
            // スーパークラスのcloneメソッドを呼ぶ.
            No043 result = (No043)super.clone();
            
            // Date型インスタンスを生成.
            Date copiedDate = new Date();
            
            // 生成したインスタンスで元データを上書き.
            result.targetDay = copiedDate;
            
            // 結果を返す.
            return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
		}
	}

	// Date型変数が保有する日時を時刻表示に変換
	public static String convertToTime(Date target) {
		// 時刻フォーマット.
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		if (target == null) {
			return null;
		} else {
			return df.format(target);
		}

    }
}