package BOJ.BOJ17299;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
BOJ17299 오등큰수
 */
public class Main {
	public static void solution(int N, String str) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strArr = str.split(" ");
		int[] numArr = new int[N];
		int[] countArr = new int[1000001];
		for(int i=0; i<N; i++){
			numArr[i] = Integer.parseInt(strArr[i]);
			countArr[numArr[i]]++;
		}

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> answer = new Stack<>();
		for(int i=N-1; i>=0; i--){
			while (true) {
				if (stack.isEmpty()) {
					answer.add(-1);
					stack.add(numArr[i]);
					break;
				} else if (countArr[stack.peek()] > countArr[numArr[i]]) {
					answer.add(stack.peek());
					stack.add(numArr[i]);
					break;
				} else{
					stack.pop();
				}
			}
		}
		while(!answer.isEmpty()){
			bw.write(answer.pop()+" ");
		}
		bw.flush();
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		solution(N, str);
	}
}
