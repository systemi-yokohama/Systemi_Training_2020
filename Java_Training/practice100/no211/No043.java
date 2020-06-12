package Java_Training.practice100.no211;

import java.util.Date;

public class No043 extends java.lang.Object implements java.lang.Cloneable {
	private Date date;

	public No043(){
		this.date = new Date();
	}

	public static void main(String args[]){
		var i = new No043();
		System.out.println(i.date);
	}
}