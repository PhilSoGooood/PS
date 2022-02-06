package BOJ.BOJ2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] makePaper(int N, int[][] paper) {
		// 흰색, 파란색
		if(N == 2){
			int whiteNum = 0;
			int blueNum = 0;

			for(int i=0; i< N; i++){
				for(int j=0; j<N; j++){
					if(paper[i][j] == 1)blueNum++;
					else whiteNum++;
				}
			}
			if(whiteNum == 0) return new int[] {0, 1};
			else  if(blueNum == 0) return new int[] {1, 0};

			return new int[] {whiteNum, blueNum};
		}


		boolean white = false;
		boolean blue = false;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(paper[i][j] == 1) blue = true;
				else if(paper[i][j] == 0) white = true;
			}
		}

		int[][] square1 = new int[N/2][N/2];
		int[][] square2 = new int[N/2][N/2];
		int[][] square3 = new int[N/2][N/2];
		int[][] square4 = new int[N/2][N/2];

		for(int i=0; i<N/2; i++){
			for(int j=0; j<N/2; j++){
				square1[i][j] = paper[i][j];
				square2[i][j] = paper[i][j+N/2];
			}
		}

		for(int i=N/2; i<N; i++){
			for(int j=0; j<N/2; j++){
				square3[i - N/2][j] = paper[i][j];
				square4[i - N/2][j] = paper[i][j+N/2];
			}
		}
		int[] countPaper =  {0, 0};


		if(white && !blue) {
			return new int[] {1, 0};
		}
		else if(!white && blue) {
			return new int[] {0, 1};
		}
		else {
			countPaper[0] =
				countPaper[0] + makePaper(N / 2, square1)[0] + makePaper(N / 2, square2)[0] + makePaper(N / 2,
					square3)[0] + makePaper(N / 2, square4)[0];
			countPaper[1] =
				countPaper[1] + makePaper(N / 2, square1)[1] + makePaper(N / 2, square2)[1] + makePaper(N / 2,
					square3)[1] + makePaper(N / 2, square4)[1];
			return countPaper;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];

		for(int i=0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] result = makePaper(N, paper);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
