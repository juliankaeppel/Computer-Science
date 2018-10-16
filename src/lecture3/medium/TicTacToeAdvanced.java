package lecture3.medium;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeAdvanced {

	public static void main(String[] args) {
		new TicTacToeAdvanced().run();
	}
	
	private void run() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			//This variable stores the state of the board in base 3.
			short board = 0;
			
			int i;
			
			//Loops up to 9 times, or until a win condition is met,
			//alternating between the player and enemy turns.
			for(i = 0; i < 9 && !checkWin(board); i++) {
				display(board);
				if(i % 2 == 0) {
					System.out.println("Your Move:");
					int input = s.nextInt();
					
					//This handles out of bounds inputs.
					while(input < 1 || input > 9 || getValue(board, input - 1) != 0) {
						System.out.println("Invalid Input!");
						input = s.nextInt();
					}
					
					board = setValue(board, input - 1, 2);
				} else {
					System.out.println("Enemy Move:");
					board = enemy(board);
				}
			}
			
			display(board);
			
			//Displays the correct win/lose/tie message.
			if(checkWin(board))
				if(i % 2 == 0)
					System.out.println("You Lose.");
				else
					System.out.println("You Win!");
			else
				System.out.println("Tie.");
			
			System.out.println("Play Again?\n1: yes\n2: no");
			
			//If the player inputs anything aside from 1, ends the game.
			if(s.nextInt() != 1)
				break;
		}
		
		s.close();
	}
	
	private short enemy(short board) {
		byte size = 0;
		
		//This counts the number of available spaces.
		for(int i = 0; i < 9; i++)
			if(getValue(board, i) == 0)
				size++;
		
		//Selects a random value from 0 (inclusive) to the number of
		//available spaces (exclusive)
		size = (byte)new Random().nextInt(size);
		
		int i;
		
		//Navigates to the correct value specified by the random number.
		for(i = 0; ; i++) {
			if(getValue(board, i) == 0) {
				if(size <= 0)
					break;
				size--;
			}
		}
		
		return setValue(board, i, 1);
	}
	
	private boolean checkWin(short board) {
		//Checks horizontal and vertical matches.
		for(int i = 0; i < 3; i++) {
			if(isRow(board, i, i + 3, i + 6) || 
					isRow(board, i * 3, i * 3 + 1, i * 3 + 2))
				return true;
		}
		
		//Checks diagonal matches.
		if(isRow(board, 0, 4, 8) || isRow(board, 2, 4, 6))
			return true;
		
		return false;
	}
	
	private boolean isRow(short board, int n1, int n2, int n3) {
		//Compares the three values and checks if they are not zero.
		return getValue(board, n1) == getValue(board, n2) && 
				getValue(board, n2) == getValue(board, n3) && 
				getValue(board, n3) != 0;
	}
	
	private short getValue(short board, int index) {
		//Returns the specific base 3 value in position 'index'.
		return (short)(board / Math.pow(3, index) % 3);
	}
	
	private short setValue(short board, int index, int value) {
		//Returns the board plus the base 3 form of 'value' in position 'index'.
		return (short)(board + value * Math.pow(3, index));
	}
	
	private void display(short board) {
		//Prints '*' for 0, 'O' for 1, and 'X' for 2
		for(int i = 0; i < 9; i++) {
			switch(getValue(board, i)) {
			case 0:
				System.out.print("*");
				break;
			case 1:
				System.out.print('O');
				break;
			case 2:
				System.out.print('X');
			}
			
			//Makes a new line after every third character.
			if((i + 1) % 3 == 0)
				System.out.println();
		}
	}
}
