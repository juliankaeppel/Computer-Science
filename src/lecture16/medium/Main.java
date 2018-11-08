package lecture16.medium;

import java.util.Scanner;

import lecture16.medium.linkedlist.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("List length: ");
		int n = s.nextInt();
		
		for(int i = 0; i < n; i++)
			list.add((int)(Math.random() * 10));

		System.out.println(list);
		
		//list.reverse();
		list.removeFirst(s.nextInt());
		
		System.out.println(list);
		
		s.close();
	}
}
