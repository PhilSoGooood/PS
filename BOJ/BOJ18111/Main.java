package BOJ.BOJ18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void solution(int N, int M, int B, int[][] land, int lowest, int highest){
		int fastestTime = Integer.MAX_VALUE;
		int maxHigh = highest;

		for(int floor=lowest; floor<=highest; floor++){
			int time = 0;
			int block = B;
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(land[i][j] < floor){
						block -= (floor - land[i][j]);
						time+=(floor - land[i][j]);
					}
					if(land[i][j] > floor){
						block += land[i][j] - floor;
						time += (land[i][j] - floor) * 2;
					}
				}
			}
			if(block < 0) continue;
			if(time < fastestTime){
				fastestTime = time;
				maxHigh = floor;
			} else if(time == fastestTime && floor > maxHigh){
				maxHigh = floor;
			}
		}
		System.out.println(fastestTime + " " + maxHigh);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);
		int lowest = 500;
		int highest = 1;
		int[][] land = new int[N][M];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				land[i][j] = Integer.parseInt(st.nextToken());
				if(land[i][j] < lowest) lowest = land[i][j];
				if(land[i][j] > highest) highest = land[i][j];
			}
		}
		solution(N, M, B, land, lowest, highest);
	}
}
