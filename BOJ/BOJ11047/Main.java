package BOJ.BOJ11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int cnt = 0;
		int[] coins = new int[N];
		for(int i=0; i<N; i++){
			coins[i] = Integer.parseInt(br.readLine());
		}
		for(int i= N-1; i>=0; i--){
			cnt += K/coins[i];
			K %= coins[i];
		}
		System.out.println(cnt);
	}
}
