package lecture7.basic;
import java.util.Scanner;

public class DiceRoll {

	public static void main(String[] args) {
		new DiceRoll().run();
	}
	
	private void run() {
		Scanner s = new Scanner(System.in);
		
		int[] d = {4, 6, 8, 10, 12, 20, 100};
		
		for(int i = 0; i < d.length; i++) {
			System.out.print("How many d" + d[i] + "'s do you want to roll?");
			d[i] = s.nextInt();
		}
		
		System.out.println("Total dice sum: " + Dice.rollSum(d[0], d[1], d[2], d[3], d[4], d[5], d[6]));
		
		s.close();
	}
}
