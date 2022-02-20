package BOJ.BOJ15664;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> set = new LinkedHashSet<>();
	public static void solution(int k, int start, int N, int M, int[] numbers, int[] arr) throws IOException {
		if(k == M){
			StringBuilder sb = new StringBuilder();
			for(int number : arr){
				sb.append(number + " ");
			}
			set.add(sb.toString());
			return;
		}

		for(int i=start; i<N; i++){
			arr[k] = numbers[i];
			solution(k+1, i+1, N, M, numbers, arr);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		int[] arr = new int[M];
		solution(0, 0, N, M, numbers, arr);
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			bw.write(iterator.next());
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
