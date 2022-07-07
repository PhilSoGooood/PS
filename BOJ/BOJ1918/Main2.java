package BOJ.BOJ1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder answer = new StringBuilder();

		Stack<Character> operator = new Stack<>();

		List<Character> addSub = Arrays.asList('+', '-');
		List<Character> multiDiv = Arrays.asList('*', '/');

		for (int i = 0; i < input.length(); i++) {
			// 피연산자인 경우
			char letter = input.charAt(i);
			if ('A' <= letter && letter <= 'Z') {
				answer.append(letter);
			} else if (addSub.contains(letter)) {
				// 연산자가 + - 인 경우
				while (!operator.isEmpty() && operator.peek() != '(') {
					answer.append(operator.pop());
				}
				operator.push(letter);
			} else if (multiDiv.contains(letter)) {
				// 연산자가 * /인 경우
				while (!operator.isEmpty() && !addSub.contains(operator.peek()) && operator.peek() != '(') {
					answer.append(operator.pop());
				}
				operator.push(letter);
			} else if (letter == ')') {
				// ')'인 경우
				while (operator.peek() != '(') {
					answer.append(operator.pop());
				}
				operator.pop();
			} else if (letter == '(') {
				// '('인 경우
				operator.push(letter);
			}
		}
		while (!operator.isEmpty()) {
			answer.append(operator.pop());
		}
		System.out.println(answer);
	}
}
