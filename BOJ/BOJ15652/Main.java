package BOJ.BOJ15652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void solution(int k, int start, int N, int M, int[] arr) throws IOException {
		if(k == M){
			for(int num : arr){
				bw.write(num + " ");
			}
			bw.write("\n");
			return;
		}

		for(int i=start; i<N+1; i++){
			arr[k] = i;
			solution(k+1, i, N, M, arr);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] arr = new int[M];
		solution(0, 1, N, M, arr);
		bw.flush();
		bw.close();
		br.close();

	}
}
