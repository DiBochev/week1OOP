package problem9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
	

	public boolean validateExpression(String ex){
		return validateBrackets(ex) && isSymbolsCorrect(ex);
	}

	private boolean isSymbolsCorrect(String ex) {
		for (int i = 1; i < ex.length(); i++) {
			if (!(Character.isDigit(ex.charAt(i))) && (ex.charAt(i) == ex.charAt(i - 1) ) ) {
				if (ex.charAt(ex.length() - 1) == ')') {
					continue;
				}
				 return false;
			}
		}
		return true;
	}

	private boolean validateBrackets(String ex) {
		int counter = 0;
		ex = ex.trim();
		for (int i = 0; i < ex.length(); i++) {
			if (ex.charAt(i) == '(') {
				counter++;
			}else if (ex.charAt(i) == ')') {
				counter--;
			}
		}
		return counter == 0;
		
	}
	
	public String calculate(String ex){
//		double result = 0;
		if (validateExpression(ex)) {
			StringBuilder sb = new StringBuilder(ex.length());
			sb.append(ex.replaceAll("\\s",""));
			StringBuilder current = new StringBuilder();
			int indexOfCloseBracket = sb.indexOf(")");
			int indexOfOpenBracket = sb.lastIndexOf("(", indexOfCloseBracket);
			
			
			while (indexOfCloseBracket != -1) {
				current.delete(0, current.length());
				current.append(sb.substring(indexOfOpenBracket + 1, indexOfCloseBracket));
				double result = calcString(current);
				
				result = calculateString(current);
				
				sb.replace(indexOfOpenBracket, indexOfCloseBracket + 1, result + "");
				indexOfCloseBracket = sb.indexOf(")");
				indexOfOpenBracket = sb.lastIndexOf("(", indexOfCloseBracket);
			}
			double tempResult = calcString(sb);
			return sb.toString();
		}
		return "not valide validate expression";
	}

	private double calcString(StringBuilder current) {
		double a[] = new double[10];
		int number = 0;
		int operator = 0;
		int digitOfNumber = 1;
		double plus = 10;
		
		for (int i = 0; i < current.length(); i++) {
			if (Character.isDigit(current.charAt(i))) {
				a[number] = a[number] * digitOfNumber;
				a[number] += Double.parseDouble(current.charAt(i) + "");
				digitOfNumber *= plus;
			}else{
				if (current.charAt(i) == '.') {
					plus = 0.1;
					digitOfNumber = 1;
				}else{
					if (operator != 0) {
						number--;
						a[number] = checkOperator(current, a, operator);		
						a[number + 1] = 0;
					}
					number++;
					operator = i;
					digitOfNumber = 1;
				}
			}
		}
		return checkOperator(current, a, operator);
	}
	
	public double calculateString(StringBuilder current){
		Pattern p = Pattern.compile("[0-9]+([.][0-9]+)?");
		Matcher m = p.matcher(current);
		m.find();
		double result = Double.parseDouble(m.group(0));;
		double tempResult;
		
		current.replace(current.indexOf(result + ""), (result + "").length(), "");
		
		
		while(m.find()){
			tempResult = Double.parseDouble(m.group(0));
			
		}
		return 0;
		
	}
	
	private double checkOperator(StringBuilder current, double[] a, int operator) {
		double result = 0;
		switch (current.charAt(operator)) {
		case '+':
			result = a[0] + a[1];
			break;
			
		case '-':
			result = a[0] - a[1];
			break;
			
		case '*':
			result = a[0] * a[1];
			break;
		
		case '/':
			result = a[0] / a[1];
			break;
			
		default:
			break;
		}
		return result;
	}
	
	public double calc2(String ex){
//		ex = ex.replaceAll("\\s","");
		StringBuilder sb = new StringBuilder(ex.length());
		sb.append(ex.replaceAll("\\s",""));
		StringBuilder current = new StringBuilder();
		int indexOfCloseBracket = sb.indexOf(")");
		int indexOfOpenBracket = sb.lastIndexOf("(", indexOfCloseBracket);
		
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(sb);
		
		while (indexOfCloseBracket != -1) {
			current.delete(0, current.length());
			current.append(sb.substring(indexOfOpenBracket +1, indexOfCloseBracket));
			m.find();
			System.out.println(m.group());
			double d = Double.parseDouble(m.group());
			int a;
		}
//		Pattern p = Pattern.compile("[+-]?[0-9]+\\.[0-9]+");
//		Pattern p = Pattern.compile("([0-9]+");
//		Matcher m = p.matcher(sb);

		
		return 0.0;
	}
}
