package Java_Training.practice100.no214;
/*以下はModelクラスのリストを文字列化して返すプログラムである。
問題点を指摘し、修正せよ。なお、Modelクラスは適切な実装が与えられているものとする。*/

public class No066 {
    private No066() {};

    public static String convertToString(List<Model> modelList) {
        String result = "";

        for (Model model : modelList) {
            if(null!=model){//モデルクラスのリストに値が入っているなら実行するという風にする。
            //result += "id:" + model.getId() + "\n";　リザルトに対して+=ではなくappendを使うべき。
            result.append( "id:");
            result.append( model.getId());
            result.append( "\n");


            //result += "name:" + model.getName() + "\n";
            result.append( "name:");
            result.append( model.getName());
            result.append( "\n");

            //result += "type:" + model.getType().getId() + "\n";
            result.append( "type:");
            result.append( model.getType().getId());
            result.append( "\n");

            //result += "memo:" + model.getMemo() + "\n";
            result.append( "memo:");
            result.append( model.getMemo());
            result.append( "\n");

            
            result.append( "---------\n");
            }
        }

        return result;
    }
}
