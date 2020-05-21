package Java_Training.practice100.no217;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class No070 {
    private static final Logger logger = Logger.getLogger("No070");

    public static void readFile() {
        //FileReader reader = null;
        
        // 修正箇所. #1, 2
        try(BufferedReader bufferReader = new BufferedReader(new FileReader(new File("c:¥¥tmp¥¥test.txt")))) {
            //File file = new File("b.txt");
            //reader = new FileReader(file);
            //int ch;
            //while ((ch = reader.read()) != -1) {
            //      System.out.print((char)ch);
            //}
            
            // ラムダ式で標準出力.
            bufferReader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "FileNotfound.", e);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException.", e);
        } //finally {
        //    try {
        //        if(reader != null) {
        //            reader.close();
        //        }
        //    } catch(IOException e) {
        //        logger.log(Level.WARNING, "close error.", e);
        //    }
        //}
    }
}