package Java_Training.practice100.no210.no030;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class No030 {
	public static void main(String[] args) {
		final var file = "data.txt";
		try(var out = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
			//例：Testクラスのオブジェクトを生成してシリアライズする
			out.writeObject(new Test("Java100本ノック", 100));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(var in = new ObjectInputStream(new FileInputStream(file))) {
			var read = (Test)in.readObject();

			//Testクラスの第一引数のインスタンス変数名はStringTextとする
			//Testクラスの第二引数のインスタンス変数名はintNumberとする
			if(Test.StringText.equals("Java100本ノック") && Test.intNumber.equals(100)) {
				System.out.println("シリアライズ・デシリアライズに成功");
			} else {
				System.out.println("シリアライズ・デシリアライズに失敗");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}