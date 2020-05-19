package Java_Training.practice100.no213.no083;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class No083 {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(No083.class.getName());
		try {
			FileHandler fHandler = new FileHandler("main-20200516.log", true);
			fHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fHandler);
			logger.setLevel(Level.INFO);
			System.out.println("Hello, World!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}