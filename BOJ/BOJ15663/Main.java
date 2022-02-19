package BOJ.BOJ15663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> set = new LinkedHashSet<>();
	public static void solution(int k, int N, int M, int[] arr, int[] numbers, boolean[] isUsed) throws IOException {
		if(k == M){
			StringBuilder sb = new StringBuilder();
			for(int num : arr){
				sb.append(num + " ");
			}
			sb.append("\n");
			set.add(sb.toString());
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] numbers = new int[N];
		boolean[] isUsed = new boolean[N];
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		solution(0, N, M, arr, numbers, isUsed);

		for(String s : set){
			bw.write(s);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
