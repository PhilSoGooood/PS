package BOJ.BOJ2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ2468 안전 영역
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxHeight = 0;
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(maxHeight < num) maxHeight = num;
			}
		}

		int answer = 0;
		for(int height = 0 ; height <= maxHeight; height++){
			int countArea = 0;
			boolean[][] visit = new boolean[N][N];
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			Queue<int[]> Q = new LinkedList<>();

			for(int x = 0; x<N; x++){
				for(int y = 0; y<N; y++){
					if(visit[x][y] == true || map[x][y] <= height) continue;
					visit[x][y] = true;
					countArea++;

					for(int dir=0; dir<4; dir++){
						int nx = x + dx[dir];
						int ny = y + dy[dir];

						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(visit[nx][ny] == true || map[nx][ny] <= height) continue;
						visit[nx][ny] = true;
						Q.add(new int[] {nx, ny});
					}

					while (!Q.isEmpty()){
						int newX = Q.peek()[0];
						int newY = Q.peek()[1];
						Q.poll();

						for(int dir=0; dir<4; dir++){
							int nx = newX + dx[dir];
							int ny = newY + dy[dir];

							if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							if(visit[nx][ny] == true || map[nx][ny] <= height) continue;
							visit[nx][ny] = true;
							Q.add(new int[] {nx, ny});
						}
					}
				if(countArea > answer) answer = countArea;
				}
			}
		}
		System.out.println(answer);
	}
}
