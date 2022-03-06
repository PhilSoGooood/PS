package BOJ.BOJ9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] tc = new int[T];
		int maxNum = 0;
		int num = 0;
		for(int i=0; i<T; i++){
			num = Integer.parseInt(br.readLine());
			tc[i] = num;
			if(num > maxNum){
				maxNum = num;
			}
		}
		int[] arr = new int[maxNum+1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i=4; i<maxNum+1; i++){
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		for(int i=0; i<T; i++){
			System.out.println(arr[tc[i]]);
		}

	}
}
