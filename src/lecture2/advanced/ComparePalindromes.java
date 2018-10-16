package lecture2.advanced;
import java.util.Random;

public class ComparePalindromes {

	public static void main(String[] args) {
		Random r = new Random();
		
		for(int i = 0; i < 1000; i++) {
			String input = "";
			for(int j = 0; j < 5; j++) {
				input += (char)(r.nextInt(26) + 97);
			}
			
			if(new Palindrome().makePalindrome(input) != new MakeBestPalindrome().run(input))
				System.out.println(i + ": " + input);
		}
	}
}
