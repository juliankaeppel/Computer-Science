package lecture2.basic;
import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int sum = 0, i;
		
		for(i = 0; ; i++) {
			int input = s.nextInt();
			if(input == 0) break;
			sum += input;
		}
		
		s.close();
		
		System.out.println("sum: " + sum + ", mean: " 
				+ String.format("%.04f", (double)sum / i));
	}
}
