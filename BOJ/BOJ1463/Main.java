package BOJ.BOJ1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i=2; i<N+1; i++){
			int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
			if(i % 3 == 0){
				x = arr[i/3] + 1;
			}
			if(i % 2 == 0){
				y = arr[i/2] + 1;
			}
			z = arr[i-1] + 1;
			arr[i] = Math.min(Math.min(x, y), z);
		}
		System.out.println(arr[N]);
	}
}
