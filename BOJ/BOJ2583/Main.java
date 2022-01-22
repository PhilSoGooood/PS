package BOJ.BOJ2583;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
BOJ2583 영역 구하기
 */
public class Main {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		int[][] arr = new int[M][N];
		for(int i=0; i<K; i++){
			String[] rectangle = br.readLine().split(" ");
			for(int x=Integer.parseInt(rectangle[1]); x<Integer.parseInt(rectangle[3]); x++){
				for(int y=Integer.parseInt(rectangle[0]); y<Integer.parseInt(rectangle[2]); y++){
					arr[x][y] = 1;
				}
			}
		}
		Queue<int[]> Q = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] visit = new int[M][N];
		List<Integer> areas = new ArrayList<>();
		int count = 0;
		for(int x=0; x<M; x++){
			for(int y=0; y<N; y++){
				if(arr[x][y] == 1 || visit[x][y] == 1) continue;
				visit[x][y] = 1;
				count++;
				Q.add(new int[] {x, y});
				int area = 0;
				while(!Q.isEmpty()){
					area++;
					int curX = Q.peek()[0];
					int curY = Q.peek()[1];
					Q.poll();

					for(int dir=0; dir<4; dir++){
						int nx = curX + dx[dir];
						int ny = curY + dy[dir];
						if(nx < 0 || nx >= M || ny <0 || ny >= N) continue;
						if(visit[nx][ny] == 1 || arr[nx][ny] == 1) continue;
						visit[nx][ny] = 1;
						Q.add(new int[] {nx, ny});
					}
				}
				areas.add(area);
			}
		}
		int[] areaArr = new int[areas.size()];
		for(int i=0; i<areas.size(); i++){
			areaArr[i] = areas.get(i);
		}
		Arrays.sort(areaArr);
		bw.write(count + "\n");
		for(int i=0; i<areaArr.length; i++){
			bw.write(areaArr[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
