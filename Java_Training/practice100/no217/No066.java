package Java_Training.practice100.no217;


public class No066 {
	private No066() {};

    public static String convertToString(List<Model> modelList) {
        //String result = "";
        StringBuilder result = new StringBuilder(); // 修正箇所. #4

        // modelListがnullでないことを保証. #1
        if (modelList == null) {
            return result.toString();
        }
               
        for (Model model : modelList) {
            // Modelオブジェクトがnullの場合はスキップ. #2
            if (model != null) {
                
                //result += "id:" + model.getId() + "\n";
                result.append("id:");
                result.append(model.getId());
                result.append("\n");
                
                //result += "name:" + model.getName() + "\n";
                result.append("name:");
                result.append(model.getName());
                result.append("\n");
                
                //result += "type:" + model.getType().getId() + "\n";
                result.append("type:");
                
                // getType()メソッドによって取得されるオブジェクトがnullの場合は、nullを表示. #3
                if (model.getType() != null) {
                    result.append(model.getType().getId());
                } else {
                    result.append("null");
                }
                result.append("\n");
                
                //result += "memo:" + model.getMemo() + "\n";
                result.append("memo:");
                result.append(model.getMemo());
                result.append("\n");
                                
                //result += "---------\n";
                result.append("---------");
                result.append("\n");
            } else {
                // Modelオブジェクトがnullの場合に、nullを表示.
                result.append("null");
                result.append("\n");
                result.append("---------");
                result.append("\n");
            }
        }
        
        return result.toString();
    }
}

