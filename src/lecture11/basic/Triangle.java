package lecture11.basic;

public class Triangle extends Shape{

	public Triangle(Side sides[]) {
		super.sides = sides;
	}
	
	public double getArea() {
		double s = (sides[0].length() + sides[1].length() + sides[2].length()) / 2d;
		
		return Math.sqrt(s * (s - sides[0].length()) * (s - sides[1].length()) * (s - sides[2].length()));
	}
}
