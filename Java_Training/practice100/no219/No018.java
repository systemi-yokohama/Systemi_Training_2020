package Java_Training.practice100.no219;

public enum No018{
	NE("子", 1), USHI("丑", 2), TORA("寅", 3), U("卯", 4), TATSU("辰", 5), MI("巳", 6),HITSUJI("未", 7), UMA("午", 8), SARU("申", 9), TORI("酉", 10), INU("戌", 11), I("亥", 12);
	//????
	private int id;
	private String name;
	
	private No018(int id,String name){
		this.id=id;
		this.name=name;
	}
	public int toJunishiValue(){
		return this.id;
	}
	@Override
	public String toString(){
		return this.name;
	}


}