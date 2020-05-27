package Java_Training.practice100.no219;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class No058 {
	public static void main(String[] args) {
		if (args.length < 1 ) {
            System.err.println("引数にテキストファイル名を指定し、再実行してください。");
            System.exit(1);
        }
        
        try {
            
            final byte[] fileContentBytes = Files.readAllBytes(Paths.get(args[0]));
            
            
            if (fileContentBytes.length < 3){
                System.out.println("BOM無しファイルです。");
                System.exit(0);
            }            
            
            // BOM判定.
            if (fileContentBytes[0] == (byte)0xEF && fileContentBytes[1] == (byte)0xBB
                    && fileContentBytes[2] == (byte)0xBF) {
                
                System.out.println("BOM付きファイルです。");
                System.exit(1);
            } else {
                System.out.println("BOM無しファイルです。");
                System.exit(0);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}