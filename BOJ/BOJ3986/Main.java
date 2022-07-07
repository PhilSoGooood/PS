package BOJ.BOJ3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static int isGood(String word) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < word.length(); i++) {
			if (stack.isEmpty() || stack.peek() != word.charAt(i)) {
				stack.push(word.charAt(i));
			} else {
				stack.pop();
			}
		}
		if (stack.isEmpty()) return 1;
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += isGood(br.readLine());
		}
		System.out.println(answer);
	}
}
