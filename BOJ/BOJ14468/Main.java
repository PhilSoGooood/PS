package BOJ.BOJ14468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Map<Character, Boolean> departed = new HashMap<>();
		Stack<Character> stack = new Stack<>();
		Stack<Character> temp = new Stack<>();
		int answer = 0;
		for (int i = 0; i < input.length(); i++) {
			char cow = input.charAt(i);
			if (departed.containsKey(cow)) {
				if (stack.peek() != cow) {
					while (stack.peek() != cow) {
						temp.push(stack.pop());
						answer++;
					}
					stack.pop();
					while (!temp.isEmpty()) {
						stack.push(temp.pop());
					}
				} else {
					stack.pop();
				}
			} else {
				departed.put(cow, true);
				stack.push(cow);
			}
		}
		System.out.println(answer);
	}
}
