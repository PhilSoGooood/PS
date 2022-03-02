package BOJ.BOJ11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;
	static Long[] totals;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void solution() throws IOException {
		String[] input = br.readLine().split(" ");
		int i = Integer.parseInt(input[0]) - 1;
		int j = Integer.parseInt(input[1]) - 1;
		if(i==0){
			bw.write(totals[j] + "\n");
		} else {
			bw.write( totals[j] - totals[i-1] + "\n");
		}
	}
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		numbers = new int[N];
		totals = new Long[N];
		Long total = 0L;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			numbers[i] = Integer.parseInt(st.nextToken());
			total += numbers[i];
			totals[i] = total;
		}
		for(int i=0; i<M; i++){
			solution();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
