package BOJ.BOJ15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(int k, int idx, int N, int M, int[] arr, boolean[] isUsed){
		if(k == M){
			for(int i=0; i<M; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i=idx+1; i<N+1; i++){
			if(isUsed[i]) continue;
			isUsed[i] = true;
			arr[k] = i;
			solution(k+1, i, N, M, arr, isUsed);
			isUsed[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		boolean[] isUsed = new boolean[N+1];
		int[] arr = new int[M];
		solution(0, 0, N, M, arr, isUsed);
	}
}
