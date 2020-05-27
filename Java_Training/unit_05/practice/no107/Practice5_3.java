package Java_Training.unit_05.practice.no107;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.LocalDateTime;

public class Practice5_3 {

	public static void main(String[] args) {

		String filePath = "C://work//project//Kenshu//Systemi_Training_2020//Java_Training//unit_05//practice//no107//sample.log";

		String mes = "qwertyuiop";

		try (var writer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("Windows-31J"),
				StandardOpenOption.APPEND)) {
			/*
			 * var writer = Files.newBufferedWriter(Paths.get(filePath),
			 * Charset.forName("Windows-31J"), StandardOpenOption.APPEND);
			 */

			writer.write(LocalDateTime.now().toString() + " " + String.join(",", mes));
			// System.out.println(LocalDateTime.now().toString() + "\r\n");
			// System.out.println(String.join(",", mes));
			writer.newLine();
			// writer.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}