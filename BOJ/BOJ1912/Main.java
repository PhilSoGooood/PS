package BOJ.BOJ1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] numbers = new int[N];
		int[]result = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		result[0] = numbers[0];
		int max = numbers[0];
		for(int i=1; i<N; i++){
			result[i] = Math.max(result[i-1] + numbers[i], numbers[i]);
			if(max < result[i]){
				max = result[i];
			}
		}
		System.out.println(max);
	}
}
