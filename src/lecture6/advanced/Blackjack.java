package lecture6.advanced;
import java.util.Random;

public class Blackjack {

	private int[] arr = new int[108];
	
	public static void main(String[] args) {
		new Blackjack().run();
	}
	
	private void run() {
		for(int i = 0; i < arr.length; i++)
			arr[i] = i;
		
		arr = shuffle(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(getCard(arr[i]));
	}
	
	/*private void player() {
		
	}*/
	
	private String getCard(int card) {
		switch(card % 12) {
		case 1:
			return "Ace";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
			default:
				return Integer.toString(card % 12);
		}
	}
	
	/**
	 * Shuffles an array and returns it.
	 * @param arr The array to shuffle.
	 * @return Returns the shuffled array.
	 */
	private int[] shuffle(int[] arr) {
		Random rand = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			int a = rand.nextInt(arr.length),
					b = rand.nextInt(arr.length),
					c = arr[a];
			arr[a] = arr[b];
			arr[b] = c;
		}
		
		return arr;
	}
}
