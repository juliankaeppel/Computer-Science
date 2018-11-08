package lecture16.medium.linkedlist;

public class LinkedList<T> {

	public LinkedListNode<T> head;
	
	public LinkedList() {}
	
	public LinkedList(LinkedListNode<T> head) {
		this.head = head;
	}
	
	public void add(T value) {
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		
		newNode.value = value;
		
		if(getLastNode() != null)
			getLastNode().next = newNode;
		else
			head = newNode;
	}
	
	public void remove(int index) {
		if(head == null)
			return;
		if(index < length() - 1) {
			LinkedListNode<T> node = getNode(index);
			
			node.value = node.next.value;
			node.next = node.next.next;
		} else {
			if(index > 0) {
				LinkedListNode<T> node = getNode(index - 1);
				node.next = null;
			} else
				head = null;
		}
	}
	
	public void removeFirst(T value) {
		if(head.next == null && head.value == value)
			head = null;
		if(head == null)
			return;
		
		LinkedListNode<T> node = head;
		
		while(node != null && node.value != value) {
			if(node.next.next == null) {
				if(node.next.value == value)
					node.next = null;
				return;
			}
			node = node.next;
		}
		
		node.value = node.next.value;
		node.next = node.next.next;
	}
	
	public void removeAll(T value) {
		if(head.next == null && head.value == value)
			head = null;
		if(head == null)
			return;
		
		LinkedListNode<T> node = head;
		
		while(node != null) { 
			if(node.value == value) {
				if(node.next.next == null) {
					if(node.next.value == value)
						node.next = null;
					return;
				}
				node.value = node.next.value;
				node.next = node.next.next;
			} else
				node = node.next;
		}
	}
	
	public void reverse() {
		head = reverse(head);
	}
	
	private LinkedListNode<T> reverse(LinkedListNode<T> node) {
		LinkedListNode<T> temp = new LinkedListNode<T>();
		
		while(node != null) {
			if(temp.value != null)
				temp.next = temp.clone();
			temp.value = node.value;
			node = node.next;
		}
		
		return temp;
	}
	
	public String toString() {
		String output = "[";
		
		LinkedListNode<T> node;
		
		if(head != null) {
			node = head.clone();
			do {
				output += node.value + ", ";
				node = node.next;
			} while(node != null);
			
			output = output.substring(0, output.length() - 2);
		}
		
		return output + "]";
	}
	
	public int length() {
		LinkedListNode<T> node = head;
		
		int i = 0;
		for(; node != null; i++)
			node = node.next;
		
		return i;
	}
	
	private LinkedListNode<T> getNode(int index) {
		LinkedListNode<T> node = null;
		
		if(head != null) {
			 node = head;
			for(int i = 0; i < index && node.next != null; i++) {
				node = node.next;
			}
		}
		
		return node;
	}
	
	private LinkedListNode<T> getLastNode() {
		LinkedListNode<T> i = null;
		
		if(head != null)
			for(i = head; i.next != null; i = i.next);
		
		return i;
	}
}
