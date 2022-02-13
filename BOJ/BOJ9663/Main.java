package BOJ.BOJ9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt = 0;

	public static void chess(int k, int N, boolean[] isUsed1, boolean[] isUsed2, boolean[] isUsed3){
		if(k == N){
			cnt++;
			return;
		}

		for(int i=0; i<N; i++){
			if(isUsed1[i] || isUsed2[k+i] || isUsed3[k-i+N-1]) continue;
			isUsed1[i] = true;
			isUsed2[k+i] = true;
			isUsed3[k-i+N-1] = true;
			chess(k+1, N, isUsed1, isUsed2, isUsed3);
			isUsed1[i] = false;
			isUsed2[k+i] = false;
			isUsed3[k-i+N-1] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isUsed1 = new boolean[N]; // 열
		boolean[] isUsed2 = new boolean[N*2]; // 좌하향 대각선
		boolean[] isUsed3 = new boolean[N*2]; // 우하향 대각선
		chess(0, N, isUsed1, isUsed2, isUsed3);
		System.out.println(cnt);


	}
}
