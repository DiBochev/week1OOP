package problem7;

import problem5.IStack;

public class LinkedStack<T> implements IStack<T> {

	
	private Node<T> lastNode;
	private int countNodes;
	
	public LinkedStack	(){
		this.countNodes = -1;
	}
	
	Node<T> getLastNode() {
		if (this.lastNode == null) {
			return null;
		}
		return this.lastNode;
	}
	
	public boolean isEmpty(){
		return countNodes == -1;
	}

	void setLastNode(Node<T> lastNode) {
		this.lastNode = lastNode;
	}

	public T getValue() {
		return this.lastNode.getValue();
	}

	@Override
	public int lenth() {
		int temp = countNodes +1;
		return temp;
	}
	
	@Override
	public void clear() {
//		this.firstNode = null;
		this.lastNode = null;
		
	}
	
	@Override
	public T peek() {
		return getLastNode().getValue();
	}

	@Override
	public T pop() {
		this.countNodes--;
		if (this.lastNode.getPreviousNode() == null) {
			return this.lastNode.getValue();
		}
		Node<T> temp = getLastNode();
		this.lastNode = this.lastNode.getPreviousNode();
		this.lastNode.getNextNode().deleteNode();
		return temp.getValue();
	}

	@Override
	public void push(T element) {
		this.countNodes++;
		if(getLastNode() == null){
			this.lastNode = new Node<T>(element, this);
		}else{
			getLastNode().addNextNode(new Node<T>(element));
			getLastNode().getNextNode().setPreviousNode(getLastNode(), this);
			this.lastNode = lastNode.getNextNode();
		}
	}

	class Node<T>{
		private Node<T> previousNode;
		private Node<T> nextNode;
		private T value;
		private LinkedStack<T> list;
		
		Node(T value, LinkedStack<T> list){
			this.value = value;
			setList(list);
		}
		
		Node(T value){
			this.value = value;
		}
		
		Node<T> getPreviousNode() {
			return previousNode;
		}

		Node<T> getNextNode() {
			return nextNode;
		}

		void setPreviousNode(Node<T> previousNode, LinkedStack<T> list) {
			this.previousNode = previousNode;
			this.list = list;
		}

		private void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}

		T getValue() {
			return value;
		}

		private LinkedStack<T> getList() {
			return list;
		}

		private void setList(LinkedStack<T> list) {
			this.list = list;
		}
		
		void addNextNode(Node<T> nextNode) {
			setNextNode(nextNode);
			getNextNode().setPreviousNode(this, list);
			if (getList() == null) {
				throw new IllegalArgumentException("set list reference");
			}
			nextNode.setList(getList());
		}
		
		void deleteNode()throws IllegalArgumentException{
			setPreviousNode(null, this.list);
			setNextNode(null);
			if (getList().isEmpty()) {
				throw new IllegalArgumentException("cannot delete last element!");
			}
		}
	}
}

	