package Java_Training.practice100.no214;
import java.io.Serializable;
import java.nio.file.Paths;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

/*java.lang.String型とint型のインスタンス変数を持つクラスをシリアライズしてファイルに保存し、そのファイルを読み込んでデシリアライズするプログラムを実装せよ。
java.io.ObjectOutputStream および java.io.ObjectInputStream を使用せよ。
デシリアライズ後にシリアライズ前の変数値が復元されていることを確認せよ。 */
public class No030 {
	private Stirng str;
	private int data;
	private String title;
	private String url; 
	final String file="C:/data/data.txt";
	private static final long SerializableUID=1L;
	private transient boolean experiod;
	public No030(String file,String title,String url,boolean experiod){
		this.file=file;
		this.title=title;
		this.url=url;
		this.experiod=experiod;
	}
    public static BufferedReader newBufferedReader(String file){
    try(var reader = Files.newBufferedReader(Paths.get(file))){
		var line=" ";
		while((line=reader.readLine())!=null){
		System.out.println(line);
	}
    } catch (IOException e) {
		e.printStackTrace();
	}
}
    public ObjectOutputStream(var out){
		try(var out =new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(new No030("writeObjectに引き渡し","url",false));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public ObjectInputStream (var in) {
		try (var in =new ObjectInputStream(new FileInputStream(file))){
		var data=(No030)in.readObject();
		System.out.println(data);
	} catch (ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
	}
	
}
