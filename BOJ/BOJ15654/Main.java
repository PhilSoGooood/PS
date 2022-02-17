package BOJ.BOJ15654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void solution(int k, int N, int M, int[] arr, int[] numbers, boolean[] isUsed) throws IOException {
		if(k == M){
			for(int number : arr){
				bw.write(number + " ");
			}
			bw.write("\n");
			return;
		}

		for(int i=0; i<N; i++){
			if(isUsed[i]) continue;
			arr[k] = numbers[i];
			isUsed[i] = true;
			solution(k+1, N, M, arr, numbers, isUsed);
			isUsed[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		int[] arr = new int[M];
		boolean[] isUsed = new boolean[N];

		for(int i=0; i<N; i++){
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		solution(0, N, M, arr, numbers, isUsed);
		bw.flush();
		bw.close();
		br.close();
	}
}
