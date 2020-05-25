package Java_Training.practice100.no210.no036;
import java.util.List;

public class No036 {

	private List<Object> members;

	public void add(Object member) {
    	synchronized(members) {
			members.add(member);
		}
	}
	
	public void replace(Object oldMember, Object newMember) {
    	synchronized (members) {
			if (members.contains(oldMember)) {
        		members.remove(oldMember);
				members.add(newMember);
			}
    	}
	}
}