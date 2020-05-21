package Java_Training.practice100.no215;

public class no018 {
	public enum Zodiac{
		Rat("子",1),Ox("丑",2),Tig("寅",3),Rab("卯",4),Dra("辰",5),Sna("巳",6),Hor("午",7),She("未",8),
		Mon("申",9),Coc("酉",10),Dog("戌",11),Pig("戌",12);

		public String name;
		public int id;

		private Zodiac(String name,int id){
			this.name=name;
			this.id=id;
		}
	}	
}