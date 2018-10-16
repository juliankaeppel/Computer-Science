package lecture6.basic;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		new Interest().run();
	}
	
	private void run() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("1: Future Value\n" + "2: Present Value\n" + "3: Exit");
			int input = s.nextInt();
			
			boolean future = false;
			
			switch(input) {
			case 1:
				future = true;
			case 2:
				System.out.print("Amount of money: ");
				Double C = s.nextDouble();
				System.out.print("Interest rate: ");
				Double r = s.nextDouble();
				System.out.print("Time period: ");
				Double T = s.nextDouble();
				System.out.println("Value: " + input(C, r, T, future));
				break;
			case 3:
				s.close();
				return;
				default:
					System.out.println("Invalid input; try again.");
			}
		}
	}
	
	private double input(Double C, Double r, Double T, boolean future) {
		return future ? fv(C, r, T) : pv(C, r, T);
	}
	
	private double fv(Double C, Double r, Double T) {
		return C * Math.pow(1d + r, T);
	}
	
	private double pv(Double C, Double r, Double T) {
		return C / Math.pow(1d + r, T);
	}
}
