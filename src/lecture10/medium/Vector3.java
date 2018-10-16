package lecture10.medium;

/*
 * Include normal vector operations for 3-vectors, including cross product. 
 * The cross product of two vectors is another vector. a cross b = ||a|| ||b|| 
 * sin(theta) n, where theta is angle between a and b, and n is unit normal vector 
 * perpendicular to both a and b. (a1, a2, a3) cross (b1, b2, b3) = 
 * (a2 b3 - a3 b2, a3 b1 - a1 b3, a1 b2 - a2 b1). Note that |a cross b| = 
 * area of the parallelogram with sides a and b. Cross product arises in definition of torque, 
 * angular momentum and vector operator curl. 
 * 
 * stuff to add
 * addition /
 * dot product
 * cross product /
 * magnitude /
 * scaling to magnitude /
 * projection
 * unit vector /
 * multiply /
 */

public class Vector3 {

	public double x, y, z;
	
	Vector3(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3 add(Vector3 v) {
		return add(v.x, v.y, v.z);
	}
	
	public Vector3 add(double x) {
		return add(x, 0, 0);
	}
	
	public Vector3 add(double x, double y) {
		return add(x, y, 0);
	}
	
	public Vector3 add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		
		return this;
	}
	
	public static Vector3 add(Vector3 v1, Vector3 v2){
		return new Vector3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vector3 multiply(double n) {
		this.x *= n;
		this.y *= n;
		this.z *= n;
		
		return this;
	}
	
	public static Vector3 multiply(Vector3 v, double n) {
		return new Vector3(v.x * n, v.y * n, v.z * n);
	}
	
	public Vector3 scale(double magnitude) {
		return multiply(magnitude / magnitude());
	}
	
	public static Vector3 scale(Vector3 v, double magnitude) {
		return multiply(v, magnitude / v.magnitude());
	}
	
	public Vector3 unitVector() {
		return scale(1);
	}
	
	public static Vector3 unitVector(Vector3 v) {
		return scale(v, 1);
	}
	
	public Vector3 crossProduct(Vector3 v) {
		return crossProduct(v.x, v.y, v.z);
	}
	
	public Vector3 crossProduct(double x, double y, double z) {
		return new Vector3(this.y * z - this.z * y, -(this.x * z - this.z * x), this.x * y - this.y * x);
	}
	
	public static Vector3 crossProduct(Vector3 v1, Vector3 v2) {
		return v1.crossProduct(v2);
	}
}
