package BOJ.BOJ2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[5];
		int total = 0;
		for(int i=0; i<5; i++){
			int num = Integer.parseInt(br.readLine());
			numbers[i] = num;
			total += num;
		}
		Arrays.sort(numbers);
		System.out.println(total / 5);
		System.out.println(numbers[2]);


	}

}
