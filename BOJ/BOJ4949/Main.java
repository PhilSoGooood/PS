package BOJ.BOJ4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static final String YES = "yes";
	static final String NO = "no";

	public static String isBalanced(String sentence) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < sentence.length(); i++) {
			// 문자가 '('이거나 '['인 경우 스택에 push
			Character letter = sentence.charAt(i);
			if (letter == '(' || letter == '[') {
				stack.push(letter);
			} else if (letter == ')') {
				// stack이 비어있거나 stack의  최상단이 '('이 아닌 경우 "no" 리턴
				if (stack.size() == 0 || stack.peek() != '(') {
					return NO;
				} else {
					stack.pop();
				}
			} else if (letter == ']') {
				// stack이 비어있거나 stack의  최상단이 '['이 아닌 경우 "no" 리턴
				if (stack.size() == 0 || stack.peek() != '[') {
					return NO;
				} else {
					stack.pop();
				}
			}
		}
		// stack이 비어있지 않으면 "no" 리턴
		if (stack.size() != 0)
			return NO;

		return YES;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input;
		// "."이 입력될때까지 입력받는다.
		while (!(input = br.readLine()).equals(".")) {
			sb.append(input);
		}
		// 입력받은 문장을 "."을 기준으로 나눈다.
		String[] sentences = sb.toString().strip().split("\\.");
		for (String sentence : sentences) {
			bw.write(isBalanced(sentence) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
