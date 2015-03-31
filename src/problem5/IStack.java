package problem5;

public interface IStack<E> {

	boolean isEmpty();
	int lenth();
	void clear();
	E peek();
	E pop();
	void push(E element);
}
