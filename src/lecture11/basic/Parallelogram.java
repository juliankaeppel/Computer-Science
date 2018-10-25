package lecture11.basic;

public class Parallelogram extends Shape {
	
	public Parallelogram(Side sides[]) {
		super.sides = sides;
	}
	
	public double getArea() {
		int i;
		for(i = 1; sides[0].slope() != sides[i].slope(); i++);
		
		Point p = new Point(sides[0].b.x - sides[0].a.x, sides[0].b.y - sides[0].a.y);
		double theta = -Math.atan2(p.y, p.x);
		
		sides[0].a = new Point(sides[0].a.x * Math.cos(theta) - sides[0].a.y * Math.sin(theta), 
				sides[0].a.x * Math.sin(theta) + sides[0].a.y * Math.cos(theta));
		sides[0].b = new Point(sides[0].b.x * Math.cos(theta) - sides[0].b.y * Math.sin(theta), 
				sides[0].b.x * Math.sin(theta) + sides[0].b.y * Math.cos(theta));
		
		sides[i].a = new Point(sides[i].a.x * Math.cos(theta) - sides[i].a.y * Math.sin(theta), 
				sides[i].a.x * Math.sin(theta) + sides[i].a.y * Math.cos(theta));
		sides[i].b = new Point(sides[i].b.x * Math.cos(theta) - sides[i].b.y * Math.sin(theta), 
				sides[i].b.x * Math.sin(theta) + sides[i].b.y * Math.cos(theta));
		
		return sides[0].length() * Math.abs(sides[i].a.y - sides[0].a.y);
	}
}
