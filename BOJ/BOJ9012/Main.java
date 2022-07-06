package BOJ.BOJ9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static final String YES = "YES";
	public static final String NO = "NO";

	public static boolean isVps(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char blank = input.charAt(i);
			//	'(' 일 경우 push
			if (blank == '(') {
				stack.push(blank);
			} else if (stack.isEmpty()) {
			// ')'인데 stack이 비어있으면 종료 -> false
				return false;
			} else if (stack.peek() == '(') {
			//  ')' 일 경우 '('가 있으면 pop
				stack.pop();
			}
		}
		if (!stack.isEmpty()) {
			// 스택이 비어있지 않으면 false
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {
			if (isVps(br.readLine())) {
				bw.write(YES);
				bw.write("\n");
			} else {
				bw.write(NO);
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
