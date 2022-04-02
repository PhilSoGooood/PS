package BOJ.BOJ2442;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String star = "*";
		String blank = " ";
		for (int i = 1; i < N+1; i++) {
			int space = N*2 - 2*i + 1;
			bw.write(blank.repeat(space/2) + star.repeat(2*i-1) +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
