package lecture11.basic;

public class Side {

	public Point a, b;
	
	public Side(double x1, double y1, double x2, double y2) {
		a = new Point(x1, y1);
		b = new Point(x2, y2);
	}
	
	public Side(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public double length() {
		return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));   
	}
	
	public double slope() {
		return (b.y - a.y) / (b.x - a.x);
	}
}
