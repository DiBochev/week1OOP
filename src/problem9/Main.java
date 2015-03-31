package problem9;


public class Main {

	public static void main(String[] args) {
		Calculator ca = new Calculator(); 
		
		String g = ca.calculate("1 + (2 +     3.001) - (4 +(4+ 9 ))") + "";
		System.out.println(g);
	}
}
