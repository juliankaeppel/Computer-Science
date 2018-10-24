package lecture11.basic;

public class Main {

	public static void main(String[] args) {
		Side sides[] = new Side[4];
		
		sides[0] = new Side(0, 0, 1, 1);
		sides[1] = new Side(0, 0, 1, -1);
		sides[2] = new Side(1, 1, 2, 0);
		sides[3] = new Side(1, -1, 2, 0);
		
		Parallelogram p = new Parallelogram(sides);
		
		System.out.println(p.getArea());
	}
}
