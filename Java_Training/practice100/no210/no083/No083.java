package Java_Training.practice100.no210.no083;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No083 {
	public static void main(String[] args) {
		var sdf = new SimpleDateFormat("YYYYMMDD");
		var input = new Date();
		var date = sdf.parse(input.toString());
		private Logger logger = LoggerFactory.getLogger("main-" + date + ".log");
		
	}	
}