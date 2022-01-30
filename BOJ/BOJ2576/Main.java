package BOJ.BOJ2576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ2576 홀수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n;
		int num;
		int min = 100;
		int sum = 0;
		while((n = br.readLine()) != null){
			num = Integer.parseInt(n);
			if(num % 2 == 0) continue;
			sum += num;
			if(min > num) min = num;
		}
		if(sum == 0){
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
