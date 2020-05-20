package Java_Training.practice100.no216;

public class No055 {
	try (BufferedReader reader = Files.newBufferedReader(Paths.get("No055.txt"))) {
		
		AtomicInteger sum = new AtomicInteger(0);
		
		reader.lines().parallel().forEach(line -> sum.addAndGet(line.length()));
		
		System.out.println(sum + "文字");
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
