package BOJ.BOJ11729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void tower(int a, int b, int N) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(N == 1){
			sb.append(a + " " + b + "\n");
			return;
		}

		tower(a, 6-a-b, N-1);
		sb.append(a + " " + b + "\n");


		tower(6-a-b, b, N-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		sb.append((1<<N) - 1 + "\n");
		tower(1, 3, N);
		System.out.println(sb.toString());
	}
}
