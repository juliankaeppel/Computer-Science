package lecture16.medium.linkedlist;

class LinkedListNode<T> {

	public T value;
	
	public LinkedListNode<T> next;
	
	public LinkedListNode<T> clone() {
		LinkedListNode<T> clone = new LinkedListNode<T>();
		clone.value = value;
		clone.next = next;
		
		return clone;
	}
}
