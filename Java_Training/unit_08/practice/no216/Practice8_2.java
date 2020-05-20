package Java_Training.unit_08.practice.no216;

public class Practice8_2 {
	public interface IFather {
		default void run() {
			System.out.println("I am a father.");
		}
	}

	public interface IMother {
		default void run() {
			System.out.println("I am a mother.");
		}
	}

	public class Parent extends Practice8_2 implements IFather, IMother {
		public void run() {
			IFather.super.run();
			IMother.super.run();
		}
	}
}