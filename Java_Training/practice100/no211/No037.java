package Java_Training.practice100.no211;
import java.util.Arrays;

public class No037 {
	Arrays list;
	Arrays rtlist;

	No037(Arrays list){
		this.list = list;
	}

	public Arrays shallow() {
		this.rtlist = Arrays.copyOf(this.list, this.list.length);
		return this.rtlist;
	}

	public Arrays deep(){
		this.rtlist = new Arrays[this.list.length];
		for(var i = 0; i < this.list.length; i++){
			this.rtlist[i] = new Arrays(this.list[i].toString());
		}
	}
}