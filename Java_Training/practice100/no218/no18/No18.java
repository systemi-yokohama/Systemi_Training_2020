package Java_Training.practice100.no218.no18;

public class No18 {
	public enum Junisi{
		JUNISI1("Rat",1),
		JUNISI2("Ox",2),
		JUNISI3("Tiger",3),
		JUNISI4("Rabbit",4),
		JUNISI5("Dragon",5),
		JUNISI6("Snake",6),
		JUNISI7("Horse",7),
		JUNISI8("Sheep",8),
		JUNISI9("Monkey",9),
		JUNISI10("Rooster",10),
		JUNISI11("Dog",11),
		JUNISI12("Pig",12)
		;

		private final String text;
		private final int id;

		private Junisi(final String text, final int id){
			this.text = text;
			this.id = id;
		}

		public String getStrinig(){
			return this.text;
		}

		public int getInt(){
			return this.id;
		}
	}
	
}