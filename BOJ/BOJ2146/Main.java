package BOJ.BOJ2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/*
BOJ2146 다리만들기
메모리 298772, 시간 4424의 놀라운 속도...
다른 해결책을 고민해보자 */
public class Main {

	public static void distinguishIsland(String[][] map, int N){
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] visit = new int[N][N];
		int islandNum = 0;
		Queue<int[]> Q = new LinkedList<>();
		for(int x=0; x<N; x++){
			for(int y=0; y<N; y++){
				if(map[x][y].equals("0") || visit[x][y] == 1) continue;
				islandNum++;
				visit[x][y] = 1;
				map[x][y] = Integer.toString(islandNum);
				Q.add(new int[]{x, y});

				while(!Q.isEmpty()){
					int curX = Q.peek()[0];
					int curY = Q.peek()[1];
					Q.poll();

					for(int dir=0; dir<4; dir++){
						int nx = curX + dx[dir];
						int ny = curY + dy[dir];
						if(nx < 0 || nx >= N || ny<0 || ny>=N) continue;
						if(visit[nx][ny] == 1 || map[nx][ny].equals("0")) continue;
						visit[nx][ny] = 1;
						Q.add(new int[] {nx, ny});
						map[nx][ny] = Integer.toString(islandNum);
					}
				}
			}
		}
	}

	public static int minDistance(String[][] map, int N){
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int minDistance = 10000;

		for(int x=0; x<N; x++){
			loop:
			for(int y=0; y<N; y++){
				if(map[x][y].equals("0")) continue;
				Queue<int[]> Q = new LinkedList<>();
				String landNum = map[x][y];
				int[][] dist = new int[N][N];
				Q.add(new int[] {x, y});
				dist[x][y] = 1;
				while (!Q.isEmpty()){
					int curX = Q.peek()[0];
					int curY = Q.peek()[1];
					Q.poll();
					for(int dir=0; dir<4; dir++){
						int nx = curX + dx[dir];
						int ny = curY + dy[dir];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(dist[nx][ny] != 0) continue;
						if(!map[nx][ny].equals("0") && !map[nx][ny].equals(landNum)){
							if(minDistance > dist[curX][curY]) minDistance = dist[curX][curY];
							continue loop;
						}
						dist[nx][ny] = dist[curX][curY]+1;
						Q.add(new int[] {nx, ny});
					}
				}
			}
		}
		return minDistance-1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] map = new String[N][N];
		for(int i=0; i<N; i++){
			map[i] = br.readLine().split(" ");
		}
		distinguishIsland(map, N);
		System.out.println(minDistance(map, N));
	}
}
