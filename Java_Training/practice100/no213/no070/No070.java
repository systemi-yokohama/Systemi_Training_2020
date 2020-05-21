/* FileReaderではなくBufferedReaderを使用する
	try-catchではなくtry-with-resourceを使用する */

package Java_Training.practice100.no213.no070;

import java.io.BufferedReader;

public class No070 {
	private static final Logger logger = Logger.getLogger("No70");

	public static void readFile() {
		try(BufferedReader bufferReader = new BufferedReader(new FileReader(new File("c:¥¥tmp¥¥test.txt")))) {
			bufferReader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "FileNotfound.", e);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException.", e);
		}
	
	}
}