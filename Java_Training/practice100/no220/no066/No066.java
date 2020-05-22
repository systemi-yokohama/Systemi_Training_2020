package Java_Training.practice100.no220.no066;
import java.util.*;


public class No066 {

	public static void main(String[] args) {
	}

		public No066() {};
		
		public static String convertToString(List<Model> modelList) {
			String result = "";
	
			for (Model model : modelList) {
				result += "id:" + model.getId() + "\n";
				result += "name:" + model.getName() + "\n";
				result += "type:" + model.getType().getId() + "\n";
				result += "memo:" + model.getMemo() + "\n";
				result += "---------\n";
			}
	
			return result;
		}
}