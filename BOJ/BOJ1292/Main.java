package BOJ.BOJ1292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int[] arr = new int[b+1];
		int index = 1;
		loop:
		for (int i = 1; i < b + 1; i++) {
			for (int j = 0; j < i; j++) {
				arr[index] = i;
				index++;
				if(index > b) break loop;
			}
		}
		int sum = 0;
		for (int i = a; i < b + 1; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
