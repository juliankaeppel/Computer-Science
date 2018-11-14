package lecture18.basic.substrings;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Parser p = new Parser(s.nextLine(), s.nextInt());
		s.close();
	
		System.out.println("Substring Count: " + p.substringCount());
		System.out.println(Arrays.toString(p.occurrenceCount()));
	}
}
