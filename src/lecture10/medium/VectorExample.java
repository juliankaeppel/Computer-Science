package lecture10.medium;


public class VectorExample {

	public static void main(String[] args) {
		Vector3 v1 = new Vector3(2, 7, 3), v2 = new Vector3(4, 9, 8);
		
		System.out.println("Original Vectors:");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println();
		
		System.out.println("Static Addition:");
		System.out.println(Vector3.add(v1, v2));
		System.out.println();
		
		System.out.println("Vector Status:");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println();
		
		System.out.println("Non-Static Addition:");
		System.out.println(v1.add(v2));
		System.out.println();
		
		System.out.println("Vector Status:");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println();
		
		System.out.println("Vector Subtraction:");
		System.out.println(v1.add(Vector3.multiply(v2, -1)));
		System.out.println();
		
		System.out.println("Dot Product:");
		System.out.println(v1.dotProduct(v2));
		System.out.println();
		
		System.out.println("Cross Product:");
		System.out.println(Vector3.crossProduct(v1, v2));
		System.out.println();
		
		System.out.println("Magnitude:");
		System.out.println(v1.magnitude());
		System.out.println(v2.magnitude());
		System.out.println();
		
		System.out.println("Scaling:");
		System.out.println(v1);
		System.out.println(v1.scale(5));
		System.out.println(v1);
		System.out.println(v1.magnitude());
		System.out.println();
		
		System.out.println("Projection:");
		System.out.println(v1.projection(v2));
		System.out.println();
		
		System.out.println("Unit Vector:");
		System.out.println(v1.unitVector());
		System.out.println(v1.magnitude());
		System.out.println();
	}
}
