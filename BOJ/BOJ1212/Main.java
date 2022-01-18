package BOJ.BOJ1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ1212 8진수 2진수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();


		for(int i=input.length()-1; i>=0; i--){
			int tmp = input.charAt(i) - '0';
			for(int j=0; j<3; j++){
				stack.add(tmp % 2);
				tmp /= 2;
			}
		}
		while(stack.size() > 1 && stack.peek() == 0){
			stack.pop();
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		System.out.println(sb);

	}
}
