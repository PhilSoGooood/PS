package BOJ.BOJ6603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void backTracking(int cur, int start, int k, int[] numbers, int[] arr) {
		if(cur == 6){
			for (int num : arr) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<k; i++){
			arr[cur] = numbers[i];
			backTracking(cur+1, i+1, k, numbers, arr);
		}
	}
	public static void solution(String[] input){
		int k = Integer.parseInt(input[0]);
		int[] numbers = new int[k];
		int[] arr = new int[6];
		for(int i=1; i<k+1; i++){
			numbers[i-1] = Integer.parseInt(input[i]);
		}
		backTracking(0, 0, k, numbers, arr);
		sb.append("\n");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String[] input = br.readLine().split(" ");
			if(input[0].equals("0")) break;
			solution(input);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
