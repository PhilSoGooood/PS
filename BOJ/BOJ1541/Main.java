package BOJ.BOJ1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\-");
		int sum = 0;
		String[] numbers = input[0].split("\\+");
		for(String num : numbers){
			sum += Integer.parseInt(num);
		}
		for(int i=1; i<input.length; i++){
			numbers = input[i].split("\\+");
			for(String num : numbers){
				sum -= Integer.parseInt(num);
			}
		}

		System.out.println(sum);
	}
}
