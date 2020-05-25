package Java_Training.practice100.no214;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.Thread;

public class No066 extends Model {
    
        public String convertToString(List < Model > modelList) {
            
        StringBuilder result =new StringBuilder(" ");
        
        
        for (Model model : modelList) {
            if(null != model){//モデルクラスのリストに値が入っているなら実行するという風にする。
            //result += "id:" + model.getId() + "\n";　リザルトに対して+=ではなくappendを使うべき。
            result.append( "id:");
            result.append(model.getId());
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
        return result.toString();
        
    }
}
