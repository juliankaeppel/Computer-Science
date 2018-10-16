package lecture1.advanced;
import java.util.Arrays;

public class Rotate {

	public static void main(String[] args) {
		//This is just a basic usage message that is triggered if you
		//input a help flag or have the wrong number of arguments.
		if(Arrays.asList(args).contains("-h") || 
				Arrays.asList(args).contains("--help") || 
				args.length != 5) {
			System.out.println("This program takes the bounds of a "
					+ "rectangle plus an angle, and returns the points "
					+ "of the rectangle rotated by that angle.");
			System.out.println("usage: top_bound right_bound "
					+ "bottom_bound left_bound angle");
			return;
		}
		
		//The bounds array stores the args inputs in double form.
		double[] bounds = new double[5];
		
		//This loop goes through args and converts each value to a
		//double, storing in bounds.
		for(int i = 0; i < args.length; i++)
			bounds[i] = Double.parseDouble(args[i]);
		
		//x and y are the center coordinates of the rectangle,
		//gotten by finding the average of the left and right, and 
		double x = (bounds[1] + bounds[3]) / 2.d, 
				y = (bounds[0] + bounds[2]) / 2.d;
		
		//angle stores the angle to rotate in radians. It also switches
		//the value from counter-clockwise to clockwise.
		double angle = Math.toRadians(360 - bounds[4]);
		
		//This loop goes through all four points that have to be rotated.
		for(int i = 0; i < 4; i++) {
			//pointX and pointY store the values of the rotated point.
			double pointX, pointY;
			
			//xBound and yBound convert the i value into the proper
			//index of bounds using fun math.
			int xBound = (i & 2) + 1, yBound = i << 1 & 2;
			
			//This applies the rotation to the points by taking the
			//x and y coordinates, subtracting the center coordinates,
			//rotating the point with trig functions, and adding back
			//the center coordinate.
			pointX = ((bounds[xBound] - x) * Math.cos(angle) 
					- (bounds[yBound] - y) * Math.sin(angle)) + x;
			pointY = ((bounds[xBound] - x) * Math.sin(angle) 
					+ (bounds[yBound] - y) * Math.cos(angle)) + y;
			
			//Prints the rounded values of pointX and pointY.
			System.out.println('(' + String.format("%.2f", pointX) 
					+ ", " + String.format("%.2f", pointY) + ')');
		}
	}
}
