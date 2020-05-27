1.  ×   ×   ×   〇   ×   
2.  interface   default extends implements  IFather.super   IMother.super
3.  public class Animal {
	private String name;
	private String age;
	public Check8_2_3(){
		this("名無権兵衛",0);

	}
	public Check8_2_3(String name, int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return this.name;
	}
	public void setName (String name){
		this.name=name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		if (age<0){
			age=0;
		}
		this.age=age;
	}
	public String intro(){
		return String.format("わたしの名前は%s.%d歳です。", getName(),getAge());
	}
}
4.  format    %2.f  extends @Override   super.show
5.  	//IAnimail.java
	public interface IAnmail{
		void move();
	}
	//Hamster.java
	public class Hamster implements IAnmail{
		private String name;
		public Hamster(String name){
			this.name=name;
		}
		@Override
		public　void move(){
			System.out.printf("%sは、トコトコ歩きます。",this.name);
		}
	}
  