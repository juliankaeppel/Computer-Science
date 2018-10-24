package lecture11.basic;

public class Circle extends Shape {

	public double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter() {
		return Math.PI * radius * 2;
	}
}
