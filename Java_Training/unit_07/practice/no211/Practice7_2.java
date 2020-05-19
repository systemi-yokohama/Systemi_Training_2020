package Java_Training.unit_07.practice.no211;

public class Practice7_2 {
	public class PCircle{
		public double radius;

		PCircle(double radius){
			this.radius = radius;
		}

		PCircle(){
			this(1);
		}

		public double getArea(){
			return Math.pow(this.radius, 2)*Math.PI;
		}
	}
}