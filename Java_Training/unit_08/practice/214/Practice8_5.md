[IAnimal.java]  
public interface IAnimal{  
　　void move(){  
　　　System.out.println("歩きます。");  
　　}...抽象クラスに本文は入れられない。  
}  
[Hamster.java]  
public class Hamster extends IAnimal{...extendsではなくimplements  
　　private String name;

　　public Hamster(String name){  
　　this.name=name;  
}  

　　public override Hamster(String name){...overrideを宣言するならメソッドの上で"@ Override"とすべき。  
　　System.out.println("%sは、トコトコ歩きます",this.name);  
　　}  
} 

 