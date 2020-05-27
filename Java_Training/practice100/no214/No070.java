package Java_Training.practice100.no214;
import  java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*以下は、テキストファイルを読み取り、その結果を出力するプログラムである。
問題点を指摘し、修正せよ。*/
public class No070 {
    private static final Logger logger = Logger.getLogger("No070");
    public static void readFile() {
        //FileReader reader = null;
        try (
            var read =new ObjectOutputStream(new FileOutputStream("c:¥¥tmp¥¥test.txt"))){
           // File file = new File("c:¥¥tmp¥¥test.txt");
            //reader = new FileReader(file);
            //int ch;
            //while ((ch = reader.read()) != -1) {
                //  System.out.print((char)ch);
            
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "FileNotfound.", e);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException.", e);
        } /*finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                logger.log(Level.WARNING, "close error.", e);
              
            }*/
        }
}