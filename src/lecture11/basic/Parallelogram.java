package lecture11.basic;

public class Parallelogram extends Shape {

	public Parallelogram(Side sides[]) {
		super.sides = sides;
	}
	
	public double getArea() {
		
		boolean isParallelogram = false;
		
		for(int i = 0; i < sides.length; i++) {
			if(sides[i].slope() != 0 && !Double.isInfinite(sides[i].slope())) {
				isParallelogram = true;
				break;
			}
		}
		
		if(!isParallelogram)
			return new Rectangle(sides).getArea();
		
		if(Double.isInfinite(sides[0].slope()))
			for(int i = 0; i < sides.length; i++) {
				Point temp = sides[i].a;
				sides[i].a.x = temp.y;
				sides[i].a.y = temp.x;
				temp = sides[i].b;
				sides[i].b.x = temp.y;
				sides[i].b.y = temp.x;
			}
		
		int i;
		for(i = 1; sides[i].slope() != sides[0].slope(); i++);
		
		double heightX = (sides[i].a.x - sides[i].slope()) / (sides[0].slope() * sides[i].slope() - sides[i].a.y);
		
		System.out.println(sides[i].a.x + "\n" + sides[i].slope() + "\n" + sides[0].slope() + "\n" + heightX);
		
		Side height = new Side(heightX, sides[0].slope() * (heightX - sides[0].a.x) + sides[0].a.y, 
				sides[i].b.x, sides[i].b.y);
		
		return sides[0].length() * height.length();
	}
}
