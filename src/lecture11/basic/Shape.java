package lecture11.basic;

public abstract class Shape implements Tangible{

	public Side sides[];
	
	public double getPerimeter() {
		
		double perimeter = 0;
		
		for(int i = 0; i < sides.length; i++)
			perimeter += sides[i].length();
		
		return perimeter;
	}
}
