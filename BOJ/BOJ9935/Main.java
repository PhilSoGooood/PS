package BOJ.BOJ9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		String empty = "FRULA";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();
		int bombSize = bomb.length();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			stack.add(input.charAt(i));
			if (stack.size() >= bombSize) {
				boolean flag = true;

				for (int j = 0; j < bombSize; j++) {
					if (stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < bombSize; j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		if (sb.length() == 0) {
			System.out.println(empty);
		} else {
			System.out.println(sb);
		}
	}
}
