package lecture2.advanced;
import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(new Palindrome().makePalindrome(s.nextLine()));
		s.close();
	}
	
	int makePalindrome(String word) {
		
		if(word.equals(reverse(word))) {
			//System.out.println("Already Palindrome");
			return 0;
		}
		
		String plausPalin = "";
		
		int lastPairCount = -1;
		
		int maxPairCount = -1;
		int centerIndex = 0;
		
		int addedChars = 0;
		
		int pairList[] = new int[word.length()];
		
		for(int i = 0; i < word.length(); i++) {
			pairList[i] = countPairs(word, i);
			lastPairCount = countPairs(word, i);
			if(lastPairCount > maxPairCount) {
				maxPairCount = lastPairCount;
				centerIndex = i;
			}
		}
		
		//System.out.println(Arrays.toString(word.toCharArray()));
		//System.out.println(Arrays.toString(pairList));
		//System.out.println("Center Index: " + centerIndex);
		
		if(centerIndex == 0) {
			for(int i = 0; i < word.length() - 1; i++)
				if(word.charAt(i) == word.charAt(i + 1)) {
					word = word.substring(0, i) + word.charAt(i) + word.substring(i);
					//System.out.println("Repeated: " + word);
					return makePalindrome(word);
				}
		} else
			plausPalin += word.charAt(0);
		
		lastPairCount = pairList[0];
		
		for(int i = 1; i < centerIndex; i++)
			if(pairList[i] > lastPairCount) {
				lastPairCount = pairList[i];
				plausPalin += word.charAt(i);
				//System.out.println("Increasing: " + plausPalin);
			}
		
		plausPalin += word.charAt(centerIndex);
		
		for(int i = centerIndex + 1;i < word.length() && word.charAt(i) == word.charAt(centerIndex) && centerIndex != 0; i++) {
			//System.out.println("addedChars++");
			addedChars++;
		}
		
		lastPairCount = pairList[centerIndex];
		
		for(int i = centerIndex + addedChars + 1; i < word.length(); i++)
			if(pairList[i] < lastPairCount) {
				lastPairCount = pairList[i];
				plausPalin += word.charAt(i);
				//System.out.println("Decreasing: " + plausPalin);
			}
		
		String left = plausPalin.substring(0, plausPalin.length() / 2),
				right = reverse(plausPalin.substring(plausPalin.length() / 2 + 1));
		
		//System.out.println("PlausPalin: " + plausPalin);
		//System.out.println("Left: " + left);
		//System.out.println("Right: " + right);
		
		if(left.equals(right)) {
			//System.out.println("Is Palindrome: " + (word.length() - plausPalin.length() - addedChars));
			return word.length() - plausPalin.length() - addedChars;
		}
		
		//System.out.println(word + "-" + plausPalin + "=" + (word.length() - plausPalin.length()));
		
		return makePalindrome(word.substring(0, centerIndex)) + 
				makePalindrome(word.substring(centerIndex + 1));
	}
	
	static String removeChar(String word, int index) {
		return word.substring(0, index) + word.substring(index + 1);
	}
	
	static String reverse(String word) {
		String reverse = "";
		for(int i = 0; i < word.length(); i++)
			reverse += word.charAt(word.length() - i - 1);
		
		return reverse;
	}
	
	static int countPairs(String word, int index) {
		
		String letters = "";
		
		//Stores all unique characters to the String, letters.
		for(int i = 0; i < word.length(); i++)
			if(letters.indexOf(word.charAt(i)) == -1)
				letters += word.charAt(i);
		
		//Initializes and populates arrays left and right.
		int[] left = new int[letters.length()],
				right = new int[letters.length()];
		
		for(int i = 0; i < letters.length(); i++) {
			left[i] = 0;
			right[i] = 0;
		}
		
		for(int i = 0; i < index; i++)
			left[letters.indexOf(word.charAt(i))]++;
		
		for(int i = index + 1; i < word.length(); i++)
			right[letters.indexOf(word.charAt(i))]++;
		
		int pairs = 0;
		
		for(int i = 0; i < letters.length(); i++)
			pairs += Math.min(left[i], right[i]);
		
		return pairs;
	}
}