package Java_Training.practice100.no214;

/*slf4j+logbackを使用してmain-YYYYMMDD.log(YYYYMMDDは出力時の年月日)にログを出力するように設定した
プログラム一式を作成せよ。
実際にHello, World!というメッセージを出力日時とレベルとソースファイルと
行番号とスレッド名に続けて同一行に出力せよ。 */
//行番号の探し方が不明
public class No083 {
	
    public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello, Wourld!");
		
    }
}