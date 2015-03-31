package problem4;

import java.util.LinkedList;
import java.util.List;

import problem5.IStack;


public class StackImpl<E> implements IStack<E>{

	private List<E> elements;
	
	public StackImpl(){
		elements = new LinkedList<E>();
	}
	
	public boolean isEmpty(){
		return lenth() == 0;
	}
	
	public int lenth(){
		return elements.size();
	}
	
	public void clear(){
		elements.clear();
	}
	
	public E peek(){
		return elements.get(elements.size() - 1);
	}
	
	public E pop(){
		E temp = elements.get(elements.size() - 1);
		elements.remove(elements.size() - 1);
		return temp;
	}
	
	public void push(E element){
		if (elements.contains(element)) {
			throw new IllegalArgumentException("element is repeating");
		}
		elements.add(element);
	}
}
