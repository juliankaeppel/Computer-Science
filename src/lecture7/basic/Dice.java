package lecture7.basic;
import java.util.Random;

public class Dice {

	public static int rollSingle(int sides) {
		int value = new Random().nextInt(sides) + 1;
		
		switch(sides) {
		case 100:
			value--;
			value /= 10;
			value *= 10;
			break;
		case 10:
			value--;
		}
		
		return value;
	}
	
	public static int rollSum(int d4, int d6, int d8, int d10, int d12, int d20, int d100) {
		int[] dice = {d4, d6, d8, d10, d12, d20, d100};
		int sum = 0;
		
		for(int i = 0; i < dice.length; i++) {
			int sides = 0;
			
			switch(i) {
			case 0:
				sides = 4;
				break;
			case 1:
				sides = 6;
				break;
			case 2:
				sides = 8;
				break;
			case 3:
				sides = 10;
				break;
			case 4:
				sides = 12;
				break;
			case 5:
				sides = 20;
				break;
			case 6:
				sides = 100;
			}
			
			for(int j = 0; j < dice[i]; j++) {
				sum += rollSingle(sides);
			}
		}
		
		return sum;
	}
}
