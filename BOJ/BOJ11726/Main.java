package BOJ.BOJ11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N+1];
		result[0] = 1;
		result[1] = 1;
		for(int i=2; i<N+1; i++){
			result[i] = (result[i-1] + result[i-2]) % 10007;
		}
		System.out.println(result[N]);
	}
}
