package BOJ.BOJ1780;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static boolean check(int[][] paper) {
		int number = paper[0][0];
		for(int i=0; i<paper.length; i++){
			for (int j=0; j<paper[0].length; j++){
				if(paper[i][j] != number)
					return false;
			}
		}

		return true;
	}

	public static int[] countPaper(int N, int[][] paper){

		if(check(paper)){
			int minusOne = 0;
			int zero = 0;
			int one = 0;
			if(paper[0][0] == -1) minusOne++;
			else if(paper[0][0] == 0) zero ++;
			else one++;
			return new int[] {minusOne, zero, one};
		}
		int[][] paper1 = new int[N/3][N/3];
		int[][] paper2 = new int[N/3][N/3];
		int[][] paper3 = new int[N/3][N/3];
		int[][] paper4 = new int[N/3][N/3];
		int[][] paper5 = new int[N/3][N/3];
		int[][] paper6 = new int[N/3][N/3];
		int[][] paper7 = new int[N/3][N/3];
		int[][] paper8 = new int[N/3][N/3];
		int[][] paper9 = new int[N/3][N/3];


		for(int i=0; i<N/3; i++){
			for(int j=0; j<N/3; j++){
				paper1[i][j] = paper[i][j];
				paper2[i][j] = paper[i][(N/3) + j];
				paper3[i][j] = paper[i][(N/3) * 2 + j];
				paper4[i][j] = paper[(N/3) + i][j];
				paper5[i][j] = paper[(N/3) + i][(N/3) + j];
				paper6[i][j] = paper[(N/3) + i][(N/3) * 2 + j];
				paper7[i][j] = paper[(N/3) * 2 + i][j];
				paper8[i][j] = paper[(N/3) * 2 + i][(N/3) + j];
				paper9[i][j] = paper[(N/3) * 2 + i][(N/3) * 2 + j];
			}
		}
		int[] numbers = {0, 0, 0};
		int[] result1 = countPaper(N/3, paper1);
		int[] result2 = countPaper(N/3, paper2);
		int[] result3 = countPaper(N/3, paper3);
		int[] result4 = countPaper(N/3, paper4);
		int[] result5 = countPaper(N/3, paper5);
		int[] result6 = countPaper(N/3, paper6);
		int[] result7 = countPaper(N/3, paper7);
		int[] result8 = countPaper(N/3, paper8);
		int[] result9 = countPaper(N/3, paper9);
		for(int i=0; i<3; i++){
			numbers[i] += result1[i] + result2[i] + result3[i] + result4[i] + result5[i] + result6[i] + result7[i] + result8[i] + result9[i];
		}
		return numbers;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] result = countPaper(N, paper);
		bw.write(result[0] + "\n");
		bw.write(result[1] + "\n");
		bw.write(result[2] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
