package BOJ.BOJ6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ6593 상범빌딩
 입력에서 계속 에러가 나서 고생했다...
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> ans = new LinkedList<>();

		loop:
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			if(!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) break;

			String[][][] building = new String[L][R][C];
			int[] start = new int[3];
			int[] exit = new int[3];

			for(int l=0; l<L; l++){
				for(int r=0; r<R; r++){
					String input = br.readLine();
					if(input.equals(""))
						input = br.readLine();
					for(int c=0; c<C; c++){
						String tmp = Character.toString(input.charAt(c));
						building[l][r][c] = tmp;
						if(tmp.equals("S")){ start = new int[] {l, r, c}; }
						else if(tmp.equals("E")){ exit = new int[] {l, r, c}; }
					}
				}
			}

			int[][][] visit = new int[L][R][C];
			visit[start[0]][start[1]][start[2]] = 1;
			Queue<int[]> Q = new LinkedList<>();
			Q.add(start);
			int[] dx = {0, 0, 1, -1, 0, 0};
			int[] dy = {1, -1, 0, 0, 0, 0};
			int[] dz = {0, 0, 0, 0, 1, -1};

			while(!Q.isEmpty()){
				int[] cur = Q.poll();
				int x = cur[1];
				int y = cur[2];
				int z = cur[0];

				if(z == exit[0] && x == exit[1] && y == exit[2]){
					ans.add("Escaped in " + (visit[z][x][y]-1) + " minute(s).");
					continue loop;
				}

				for(int dir = 0; dir<6; dir++){
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					int nz = z + dz[dir];

					if(nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L) continue;
					if(visit[nz][nx][ny] != 0 || building[nz][nx][ny].equals("#")) continue;
					visit[nz][nx][ny] = visit[z][x][y] + 1;
					Q.add(new int[] {nz, nx, ny});
				}
			}
			ans.add("Trapped!");
		}
		while (!ans.isEmpty()){
			System.out.println(ans.poll());
		}
	}
}
