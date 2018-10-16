package lecture3.medium;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeBasic {

	public static void main(String[] args) {
		new TicTacToeBasic().run();
	}
	
	private void run() {
		byte[][] board = new byte[3][3];
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				board[i][j] = 0;
		
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
		
			display(board);
			
			byte x = s.nextByte(), y = s.nextByte();
			
			while(!(x > 0 && x < 4 && y > 0 && y < 4 && board[y - 1][x - 1] == 0)) {
				System.out.println("Invalid Coordinate!");
				display(board);
				x = s.nextByte();
				y = s.nextByte();
			}
			
			board[y - 1][x - 1] = 1;
			
			if(checkWin(board)) {
				display(board);
				System.out.println("You Win!");
				break;
			}
			
			if(i < 4) {
				board = enemy(board);
				if(checkWin(board)) {
					display(board);
					System.out.println("You Lose.");
					break;
				}
			} else
				System.out.println("Tie.");
		}
		
		s.close();
	}
	
	private boolean checkWin(byte[][] board) {
		for(int i = 0; i < 3; i++) {
			if((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != 0) ||
					(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != 0))
				return true;
		}
		
		if((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != 0) || 
				(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != 0))
			return true;
		
		return false;
	}
	
	private byte[][] enemy(byte[][] board) {
		final class Point{
			private int x, y;
			
			Point(int x, int y) {
				setPoint(x, y);
			}
			
			public void setPoint(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		

		ArrayList<Point> p = new ArrayList<Point>();
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(board[i][j] == 0)
					p.add(new Point(i, j));
		
		Point select = p.get(new Random().nextInt(p.size()));
		
		board[select.x][select.y] = -1; 
		
		System.out.println((select.y + 1) + ", " + (select.x + 1));
		
		return board;
	}
	
	private void display(byte[][] board) {
		System.out.println("  1 2 3");
		for(int i = 0; i < 3; i++) {
			System.out.print(" -------\n" + (i + 1));
			for(int j = 0; j < 3; j++) {
				char mark = board[i][j] == 1 ? 'X' : 
					(board[i][j] == -1 ? 'O' : '*');
				System.out.print("|" + mark);
			}
			System.out.println("|");
		}
		System.out.println(" -------");
	}
}
