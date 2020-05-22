package Java_Training.practice100.no219;

public enum No018 {  
    RED("赤", 1), GREEN("緑", 2), BLANK("白", 3), YELLO("黄", 4);  
    private String name;  
    private int index;  
    private No018(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    @Override  
    public String toString() {  
        return this.index+" "+this.name;  
	}  
	public String toValue(){
		return this.name;
	}
}  
//No018_.javaに実行できる。