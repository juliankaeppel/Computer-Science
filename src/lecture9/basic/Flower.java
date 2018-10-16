package lecture9.basic;

import java.awt.Color;

public class Flower {

	Color flowerColor;
	
	int petalCount;
	
	double diameter;
	
	Flower(Color color, int petalCount, double diameter){
		flowerColor = color;
		this.petalCount = petalCount;
		this.diameter = diameter;
	}
}
