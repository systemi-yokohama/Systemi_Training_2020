/* 文字列なのに+=で連結している
   Stringは参照型なのにnullチェックをしていない*/ 

package Java_Training.practice100.no213.no066;

import java.util.List;

public class No066 {
	private No066() {};

	public static String convertToString(List<Model> modelList) {
		String result = "";
		StringBuilder stb = new StringBuilder();

		if(modelList == null) {
			return null;
		}

		for(Model model : modelList) {
			if(model != null) {

				result = (stb.append("id:").append(model.getId()).append("\n"));
				result = (stb.append("name:").append(model.getName()).append("\n"));
				result = (stb.append("type:").append(model.getType()).append(model.getId()).append("\n"));
				result = (stb.append("memo:").append(model.getMemo()).append("\n"));
				result = stb.append("---------\n");
				if(model.getId() == null) {
					return null;
				}
				if(model.getName() == null) {
					return null;
				}
				if(model.getType() == null) {
					return null;
				}
				if(model.getMemo() == null) {
					return null;
				}
			} else {
				return null;
			}
		}
		return result;
	}
}