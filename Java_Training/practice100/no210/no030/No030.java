package Java_Training.practice100.no210.no030;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class No030 {
	private String text;
	private int number;
	public static void main(String[] args) {
		final var file = "C:/data/data.txt";
		var data = new No030("Java100本ノック", 100);
		try(var out = new ObjectOutputStream(new FileOutputStream(file))) {
			//例：No030クラスのオブジェクトをシリアライズする
			out.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(var in = new ObjectInputStream(new FileInputStream(file))) {
			var des = (No030)in.readObject();

			if(des.text.equals("Java100本ノック") && des.number ==  100) {
				System.out.println("シリアライズ・デシリアライズに成功");
			} else {
				System.out.println("シリアライズ・デシリアライズに失敗");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	} 

	public No030(String text, int number){
		this.text = text;
		this.number = number;
	}
}