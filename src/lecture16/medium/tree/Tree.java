package lecture16.medium.tree;

public class Tree {

	BinaryTreeNode root;
	
	public void parseTree(String input) {
		if(input.length() == 0 || Math.log(input.length() + 1) / Math.log(2) % 1 != 0) {
			System.out.println("Invalid input!");
			return;
		}
		
		BinaryTreeNode node = root, left, right;
		
		node.value = Character.getNumericValue(input.charAt(0));
		
		for(int i = 1; i < input.length(); i++) {
			
		}
	}
}
