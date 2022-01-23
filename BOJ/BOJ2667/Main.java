package BOJ.BOJ2667;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// BOJ2667 단지번호붙이기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[][] board = new String[N][N];
		for(int i=0; i<N; i++){
			board[i] = br.readLine().split("");
		}
		Queue<int[]> Q = new LinkedList<>();
		int count  = 0;
		ArrayList<Integer> vilageNum = new ArrayList<>();
		int[][] visit = new int[N][N];

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		for(int x=0; x<N; x++){
			for(int y=0; y<N; y++){
				if(visit[x][y] == 1 || board[x][y].equals("0")) continue;
				visit[x][y] = 1;
				Q.add(new int[] {x, y});
				count++;

				int hounseNum = 0;
				while(!Q.isEmpty()){
					hounseNum++;
					int curX = Q.peek()[0];
					int curY = Q.peek()[1];
					Q.poll();
					for(int dir=0; dir<4; dir++){
						int nx = curX + dx[dir];
						int ny = curY + dy[dir];

						if(nx<0 || nx >=N || ny<0 || ny >= N) continue;
						if(board[nx][ny].equals("0") || visit[nx][ny] ==1) continue;
						visit[nx][ny] = 1;
						Q.add(new int[] {nx, ny});
					}
				}
				vilageNum.add(hounseNum);
			}
		}
		bw.write(count + "\n");
		int[] listToArr = new int[vilageNum.size()];
		for(int i=0; i< vilageNum.size(); i++){
			listToArr[i] = vilageNum.get(i);
		}
		Arrays.sort(listToArr);
		for (int j : listToArr) {
			bw.write(j + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
