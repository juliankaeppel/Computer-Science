package lecture9.basic;

import java.awt.Color;

public class Leaf {

	Color leafColor;
	
	// The number of sub-leaves on the leaf.
	int subLeaves;
	
	private boolean isReceivingLight;
	boolean isMakingSugar;
	
	Leaf(Color color, boolean isReceivingLight, int subLeaves){
		leafColor = color;
		this.isReceivingLight = isReceivingLight;
		checkForSugarProduction();
		this.subLeaves = subLeaves;
	}
	
	void givePlantLight() {
		isReceivingLight = true;
		checkForSugarProduction();
	}
	
	void removePlantLight() {
		isReceivingLight = false;
		checkForSugarProduction();
	}
	
	void checkForSugarProduction() {
		if(isReceivingLight)
			isMakingSugar = true;
		else
			isMakingSugar = false;
	}
}
