package Java_Training.unit_09.practice.no214;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;


public class Practice9_4_3{  
	public static void dda(){
	var file="ファイル"; 
	FileInputStream in =null;

	try (var in2 =new FileInputStream(file) ){
	  //空欄指定
	
	} catch (IOException  |  SQLException e ) {
		
		System.out.println("空欄指定");
		//空欄指定

	
	}
	} 
}

