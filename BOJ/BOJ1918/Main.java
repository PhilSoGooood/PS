package BOJ.BOJ1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/*
BOJ1918 후위 표기식
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<input.length(); i++){
			char chr = input.charAt(i);
			if(64 < (int)chr && (int)chr < 91){
				sb.append(chr);
			} else {
				if(chr == '(') stack.add(chr);
				else if(chr == ')'){
					while(stack.peek() != '(') sb.append(stack.pop());
					stack.pop();
				} else {
					if(stack.isEmpty()) stack.add(chr);
					else{
						if(map.get(stack.peek()) >= map.get(chr)){
							while(!stack.isEmpty() && (map.get(stack.peek()) >= map.get(chr))){
								sb.append(stack.pop());
							}
						}
						stack.add(chr);
					}
				}
			}
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
}
