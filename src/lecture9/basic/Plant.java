package lecture9.basic;

public class Plant {

	// The number of leaves
	private int leafCount;
	
	Leaf leaf;
	
	private int flowerCount;
	
	Flower flowerType;
	
	// The plant's physical position
	int x, y, z;
	
	double height;
	
	static boolean doesEarthExist = true;
	
	boolean isPlantAlive;
	
	Plant(int x, int y, int z, double height, int leafCount, Leaf leaf, int flowerCount, Flower flowerType){
		this.x = x;
		this.y = y;
		this.z = z;
		this.height = height;
		this.leafCount = leafCount;
		this.leaf = leaf;
		this.flowerCount = flowerCount;
		this.flowerType = flowerType;
		
		updatePlantStatus();
	}
	
	void updatePlantStatus() {
		// If earth exists, the plant is alive. Otherwise, it isn't.
		if(doesEarthExist)
			isPlantAlive = true;
		else
			isPlantAlive = false;
	}
	
	// Removes n leaves from the plant
	void cutLeaves(int n) {
		leafCount = Math.max(leafCount - n, 0);
	}
	
	int lookAtLeaves() {
		return leafCount;
	}
	
	// I couldn't come up with any naturally static plant-related methods, so the flower methods are static.
	
	// Removes n flowers from the plant
	static void pickFlowers(Plant plant, int n) {
		plant.flowerCount = Math.max(plant.flowerCount - n, 0);
	}
	
	static int lookAtFlowers(Plant plant) {
		return plant.flowerCount;
	}
}
