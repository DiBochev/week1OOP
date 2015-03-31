package problem3;

public final class Pair<T> {

	private final T obj;
	private final T obj2;
	
	public Pair(T obj, T obj2){
		this.obj = obj;
		this.obj2 = obj2;
	}
	
	public T getFirst(){
		return this.obj;
	}
	
	public T getSecond(){
		return this.obj2;
	}
	
	@Override
	public String toString() {
		return "first obj" + this.obj.toString() + "second obj" + obj2.toString();
	}

	public boolean equals(Pair p) {
		if ((p.getFirst() == this.obj) || (p.getFirst() == this.obj2)) {
			if ((p.getSecond() == this.obj) || (p.getSecond() == this.obj2)) {
				return true;
			}
		}
		return false;
	}
}
