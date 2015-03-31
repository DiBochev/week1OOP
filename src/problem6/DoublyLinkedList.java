package problem6;

public class DoublyLinkedList<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private Node<T> currentNode;
	private int countNodes = -1;
	
	public DoublyLinkedList(){
	}
	
	public Node<T> getFirstNode() {
		while (this.firstNode.HasPreviousNode()) {
			this.firstNode = this.firstNode.getPreviousNode();
		}
		this.currentNode = firstNode;
		return this.currentNode;
	}
	
	public Node<T> getLastNode() {
		while (this.lastNode.HasNextNode()) {
			this.lastNode = this.lastNode.getNextNode();
		}
		this.currentNode = lastNode;
		return this.lastNode;
	}
	
	public Node<T> getCurrentNode(){
		return this.currentNode;
	}
	
	public boolean isEmpty(){
		return (countNodes == -1);
	}
	
	void setFirstNode(Node<T> firstNode) {
		this.firstNode = firstNode;
	}

	void setLastNode(Node<T> lastNode) {
		this.lastNode = lastNode;
	}

	public Node<T> getNextNode() {
		currentNode = currentNode.getNextNode();
		return currentNode;
	}
	
	public Node<T> getPreviousNode(){
//		if (currentNode.getPreviousNode() == null) {
//			return currentNode;
//		}
		currentNode = currentNode.getPreviousNode();
		return currentNode;
	}

	public T getValue() {
		return currentNode.getValue();
	}
	
	private boolean isCurrentNodeNull (T value){
		if (currentNode == null) {
			currentNode = new Node<T>(value, this);
			this.firstNode = currentNode;
			this.lastNode = currentNode;
			countNodes++;
			return true;
		}
		return false;
	}

	public void addPreviousNode(T value){
		countNodes++;
		if (!isCurrentNodeNull (value)) {
			Node<T> temp = currentNode.getPreviousNode();
			if (currentNode.getPreviousNode() == null) {
				currentNode.setPreviousNode(new Node<T>(value, this));
				currentNode.getPreviousNode().setNextNode(currentNode);
				currentNode = currentNode.getPreviousNode();
			}else{
				temp.setNextNode(new Node<T>(value, this));
				temp.getNextNode().setPreviousNode(temp);
				
				currentNode.setPreviousNode(temp.getNextNode());
				temp.getNextNode().setNextNode(currentNode);
				
				currentNode = currentNode.getPreviousNode();
			}
		}
	}
	
	public void addNextNode(T value) {
		if (!isCurrentNodeNull (value)) {
			if (currentNode.getNextNode() == null) {
				currentNode.setNextNode(new Node<T>(value, this));
				currentNode.getNextNode().setPreviousNode(currentNode);
				currentNode = currentNode.getNextNode();
				countNodes++;
			}else{
				currentNode = currentNode.getNextNode();
				addPreviousNode(value);
			}
		}
	}
	
	public void deleteNode(){
		countNodes--;
		if (currentNode.getNextNode() == null && currentNode.getPreviousNode() == null) {
			currentNode = null;
		}else if (currentNode.getPreviousNode() == null) {
			currentNode = currentNode.getNextNode();
			firstNode = currentNode;
			currentNode.getPreviousNode().deleteNode();
			currentNode.setPreviousNode(null);
		}else if(currentNode.getNextNode() == null){
			currentNode = currentNode.getPreviousNode();
			lastNode = currentNode;
			currentNode.getNextNode().deleteNode();
			currentNode.setNextNode(null);
		}else {
			Node<T> temp = currentNode.getPreviousNode();
			currentNode = currentNode.getNextNode();
			temp.setNextNode(currentNode);
			currentNode.getPreviousNode().deleteNode();
			currentNode.setPreviousNode(temp);
		}
	}
}