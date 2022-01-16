package BOJ.BOJ2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ2004 조합 0의 개수
public class Main {
	public static long countFive(long num){
		long count = 0;
		while(num >= 5){
			count += (num / 5);
			num /= 5;
		}
		return count;
	}

	public static long countTwo(long num){
		long count = 0;
		while(num >= 2){
			count += (num / 2);
			num /= 2;
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		long five = countFive(n) - countFive(n-m) - countFive(m);
		long two = countTwo(n) - countTwo(n-m) - countTwo(m);
		System.out.println(Math.min(five, two));
	}
}
