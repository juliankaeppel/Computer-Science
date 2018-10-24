package lecture11.basic;

public class Rectangle extends Shape {

	public Rectangle(Side sides[]) {
		super.sides = sides;
	}
	
	public double getArea() {
		int i;
		for(i = 1; sides[i].slope() == sides[0].slope(); i++);
		
		return sides[0].length() * sides[i].length();
	}

}
