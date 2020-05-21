package Java_Training.practice100.no214;
//ユニークな名前とIDを持ち、名前とIDどちらでもインスタンスが取得できるenumを実装せよ。
//例として、十二支を表現するenumを実装せよ。

public enum No018 {
   RAT(0,"子"),
   OX(1,"丑"),
   TIGER(2,"寅"),
   RABBIT(3,"卯"),
   DRAGON(4,"辰"),
   SNAKE(5,"巳"),
   HOUSE(6,"午"),
   RAM(7,"未"),
   MONKEY(8,"申"),
   ROOSTER(9,"酉"),
   DOG(10,"戌"),
   BOUR(11,"亥");
   //フィールド
   private int id;
   private String name;
   //コンストラクター、ゲッター
   private No018(int id,String name){
	   this.id=id;
	   this.name=name;
   }

   public int getId(){
	   return this.id;
   }
   @Override//名前を取得するときに日本語表記で取得されるようにする
   public String toString(){
	   return this.name;
   }

  public static No018 etoName(final int id) {
    for (final No018 vd : No018.values()) {
        if (vd.id == id) {
            return vd;
        }
    }
    return null;
}
public static No018 etoId(final String name) {
  for (final No018 vd : No018.values()) {
      if (vd.name == name) {
          return vd;
      }
  }
  return null;
}




}
class Main{
	public static void main(String[] args){
    var animal=new No018();		
		System.out.println(No018.etoName());
	} 
}