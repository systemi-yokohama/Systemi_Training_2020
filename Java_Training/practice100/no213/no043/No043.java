package Java_Training.practice100.no213.no043;

import java.text.SimpleDateFormat;
import java.util.Date;

public class No043 implements Cloneable {
	Date date = new Date(20200525L);
	public static void main(String[] args) {
		No043 no043 = new No043();
		No043 dpc = no043.clone();
		no043.date.setTime(20200526L);

		if(dpc == null) {
			System.out.println(dpc);
		} else {
			System.out.println("インスタンス生成時刻:" + convertToTime(dpc.date));
		}
		System.out.println("書き換え時刻:" + convertToTime(no043.date));
	}
	@Override
	public No043 clone() {
		try {
			No043 result = (No043)super.clone();
			Date cpdate = new Date();
			result.date = cpdate;
			return result;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e);
		}
	}
	public static String convertToTime(Date date) {
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
		if(date == null) {
			return null;
		} else {
			return fm.format(date);
		}
	}
}