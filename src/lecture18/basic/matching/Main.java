package lecture18.basic.matching;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		Parser p = new Parser(input);
		
		s.close();
		
		System.out.println(p.isValid());
	}
}
