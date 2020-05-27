package Java_Training.unit_09.practice.no214;

//import java.util.jar.Attributes.Name;

public class Practice9_4_4 {
	private static class Sub{
		
		private void show(){
			System.out.println("空指定");
		}

	}
	public void showview(){
		var sv=new Sub();
		sv.show();
		//本来は空指定
	}
}