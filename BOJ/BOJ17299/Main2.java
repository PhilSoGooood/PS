package BOJ.BOJ17299;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] numbers = new int[N];
		int[] count = new int[1000001];

		for (int i=0; i<N; i++) {
			int number = Integer.parseInt(input[i]);
			numbers[i] = number;
			count[number]++;
		}
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> answer = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			// 지금 위치를 기준으로 등장 횟수가 더 작은 것들은 전부 Pop
			while (true) {
				if (stack.isEmpty()) {
					answer.push(-1);
					stack.push(numbers[i]);
					break;
				} else if (count[stack.peek()] > count[numbers[i]]) {
					answer.push(stack.peek());
					stack.push(numbers[i]);
					break;
				} else {
					stack.pop();
				}
			}
		}
		while (!answer.isEmpty()) {
			bw.write(answer.pop().toString() + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
