package lecture9.basic;

import java.awt.Color;

public class PlantProgram {

	public static void main(String[] args) {
		Leaf leaf = new Leaf(Color.green, true, 5);
		Flower flower = new Flower(Color.white, 13, 1.5);
		
		Plant plant = new Plant(0, 0, 0, 10, 100, leaf, 8, flower);
		
		System.out.println("Leaf count:");
		System.out.println(plant.lookAtLeaves());
		plant.cutLeaves(20);
		System.out.println(plant.lookAtLeaves());
		
		System.out.println("Leaf sugar production:");
		System.out.println(leaf.isMakingSugar);
		leaf.removePlantLight();
		System.out.println(plant.leaf.isMakingSugar);
		
		System.out.println("Plant aliveness:");
		System.out.println(plant.isPlantAlive);
		Plant.doesEarthExist = false;
		plant.updatePlantStatus();
		System.out.println(plant.isPlantAlive);
	}
}
