package Java_Training.practice100.no216;
import java.nio.*;

public class No057 {
	public static void main(String[] args) {
		if (args.length < 1 ) {
            System.err.println("data.txt");
            System.exit(1);
		}
		
		try (Stream<String> txtFile = Files.lines(Paths.get(args[0]))) {
			txtFile.map(line -> line).forEach(System.out::println);
			final FileSystem fileSystem = FileSystems.getDefault();
			final Path beforeFile = Paths.get(args[0]);
			final Path afterFile = fileSystem.getPath(args[0] + ".read");
			Files.copy(beforeFile, afterFile, REPLACE_EXISTING);
			Files.deleteIfExists(beforeFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}