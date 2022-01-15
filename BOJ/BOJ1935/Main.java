package BOJ.BOJ1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


/*
BOJ1935 후위 표기식2
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String expression = br.readLine();
		HashMap<Character, Double> map = new HashMap<>();
		for(int i=65; i<65+N; i++){
			char key = (char)i;
			double value = Double.parseDouble(br.readLine());
			map.put(key, value);
		}
		Stack<Double> stack = new Stack<>();
		List<Character> operand = List.of('-', '+', '*', '/') ;
		for(int i=0; i<expression.length(); i++){
			char obj = expression.charAt(i);
			if(operand.contains(obj)){
				double y = stack.pop();
				double x = stack.pop();
				if(obj == '+'){
					stack.add(x+y);
				} else if(obj == '*'){
					stack.add(x * y);
				} else if(obj == '/'){
					stack.add(x / y);
				} else if(obj == '-'){
					stack.add(x-y);
				}
			} else {stack.add(map.get(obj));}
		}
		System.out.println(String.format("%.2f", stack.pop()));

	}
}
