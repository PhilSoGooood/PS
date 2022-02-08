package BOJ.BOJ10093;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//BOJ10093 숫자
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long A, B;
		if(a < b) {
			A = a;
			B = b;
		}
		else {
			A = b;
			B = a;
		}

		boolean check = false;
		if (B == A || B-A-1 == 0) {
			bw.write(0 + "\n");
			check = true;
		} else {
			bw.write(B - A - 1 + "\n");
		}

		if (!check) {
			for (long i = A + 1; i < B; i++) {
				bw.write(i + " ");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
