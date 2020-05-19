package Java_Training.unit_07.practice.no213;

public class Practice7_2__PCircle {
	public double radius;
	public Practice7_2__PCircle(double radius) {
		this.radius = radius;
	}

	public Practice7_2__PCircle() {
		this.radius = 1;
	}
	
	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}
}