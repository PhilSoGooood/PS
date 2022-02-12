package BOJ.BOJ15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(int N, int M, int k, int[] arr, boolean[] isUsed){
		if(k == M){
			for(int i=0; i<M; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i=1; i<N+1; i++){
			if(!isUsed[i]){
				arr[k] = i;
				isUsed[i] = !isUsed[i];
				solution(N, M, k+1, arr, isUsed);
				isUsed[i] = !isUsed[i];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		boolean[] isUsed = new boolean[N+1];
		int[] arr = new int[M];
		solution(N, M, 0, arr, isUsed);

	}
}
