package lecture2.advanced;
import java.util.Scanner;
/**
 * Solution for palindrome assignment.
 * 
 * This is not the optimal solution, but is correct and uses more or less
 * the tools introduced in class. The optimal solution introduces a dynamic
 * programming technique to avoid rechecking solutions (e.g. there are two
 * possible subsequences of "abbc" that are both "ab" - no reason to check
 * the second one separately), which is beyond our current capabilities in class.
 * 
 * @author Will Schindler
 */
public class MakeBestPalindrome {
    
	public static void main(String[] args) {
		String input;
		try (Scanner s = new Scanner(System.in)) {
            input = s.nextLine();
        }
        System.out.println(new MakeBestPalindrome().run(input));
    }
    
    int run (String input) {
        //try-wrapping handles bad input and closes the Scanner when done
        
        //Bail out if no input or lenth zero
        if (input == null || input.length() == 0)
            System.exit(1);
        
        //This will make it more convenient to keep grabbing single characters
        char[] inputChars = input.toCharArray();
        
        //initialize at the worst possible solution: duplicating everything
        int best = input.length();
        
        //A string of length n has 2^n possible substrings
        //Test each substring to figure out if it's a palindrome, keep the best
        //We represent each as binary of length n - 1 means "include the character"
        for (int i = 1; i < Math.pow(2, input.length()); i++) {
        	//System.out.println(i);
            char[] candidate = new char[input.length()];
            int candidateLength = 0;
            
            //Determine whether each character goes into the candidate
            int digit = 1;
            for (int j = 0; j < input.length(); j++) {
                if ((i & digit) != 0) //if the next bit is one...
                    //stick that char in the builder
                    candidate[candidateLength++] = inputChars[j]; 
                digit = digit << 1; //you could also do *= 2... next digit
            }
            
            //is this candidate a palindrome?
            boolean isPalindrome = true;
            for (int j = 0; j < candidateLength / 2; j++)
                if (candidate[j] != candidate[candidateLength - 1 - j]) {
                    isPalindrome = false;
                    break;
                }
            
            //Use this if you want to see each candidate evaluated
            //System.out.println("Candidate " + new String(candidate) + ", " + isPalindrome);
            
            //If it still looks like a palindrome, update "best"
            if (isPalindrome) {
                int difference = input.length() - candidateLength;
                if (difference < best)
                    best = difference;
            }
        }
        
        //System.out.println(best);
        return best;
    }   
}