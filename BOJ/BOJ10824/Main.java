package BOJ.BOJ10824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ10824 네 수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		String AB = arr[0] + arr[1];
		String CD = arr[2] + arr[3];

		System.out.println(Long.parseLong(AB) + Long.parseLong(CD));

	}
}
