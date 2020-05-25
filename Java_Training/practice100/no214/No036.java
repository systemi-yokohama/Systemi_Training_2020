package Java_Training.practice100.no214;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*排他
以下のプログラムをスレッドセーフにせよ。排他処理は極力短くなるようにせよ
。
private List<Object> members;
public void add(Object member) {
    members.add(member);
}
public void replace(Object oldMember, Object newMember) {
    if (members.contains(oldMember)) {
        members.remove(oldMember);
        members.add(newMember);
    }
} */
public class No036 {
    
    private List<Object> members;
   
    synchronized void add(Object member){
        members.add(member);
    }
    synchronized void replace(Object oldMember ,Object newMember) {
        if(members.contains(oldMember)){
            members.remove(oldMember);
            members.add(newMember);
        }        
    }

}