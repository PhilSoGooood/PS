package BOJ.BOJ11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] people = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(people);
		int ans = 0;
		for (int i=0; i<N; i++) {
			ans += people[i] * (N-i);
		}
		System.out.println(ans);
	}
}
