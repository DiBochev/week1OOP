package problem6;

public class Node<T>{

	private Node<T> previousNode;
	private Node<T> nextNode;
	private T value;
	
	Node(T value, DoublyLinkedList<T> list){
		this.setValue(value);
	}
	
	Node(T value){
		this.setValue(value);
	}
	
	Node<T> getPreviousNode() {
		return previousNode;
	}

	boolean HasPreviousNode() {
		return (previousNode != null);
	}

	boolean HasNextNode() {
		return (nextNode != null);
	}
	
	Node<T> getNextNode() {
		return nextNode;
	}

	void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}

	void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	T getValue() {
		return value;
	}

	void setValue(T value) {
		this.value = value;
	}

	void deleteNode()throws IllegalArgumentException{
		setPreviousNode(null);
		setNextNode(null);
	}
}