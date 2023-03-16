package BOJ.BOJ2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[][] map = new int[N][M];
        for (int i=0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j=0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][][] dist = new int[N][M][2];

        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }

        System.out.println(bfs(N, M, map, dist));
    }

    private static int bfs(int N, int M, int[][] map, int[][][] dist) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};



        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0][0] = 1;
        dist[0][0][1] = 1;
        dq.add(new int[]{0, 0, 0});

        while (!dq.isEmpty()) {
            int[] arr = dq.pollFirst();
            int x = arr[0];
            int y = arr[1];
            int broken = arr[2];

            if (x == N-1 && y == M-1) return dist[x][y][broken];

            int nextDist = dist[x][y][broken] + 1;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0 && dist[nx][ny][broken] == -1) {
                    dist[nx][ny][broken] = nextDist;
                    dq.add(new int[]{nx, ny, broken});
                }
                if (broken == 0 && map[nx][ny] == 1 && dist[nx][ny][1] == -1) {
                    dist[nx][ny][1] = nextDist;
                    dq.add(new int[]{nx, ny, 1});
                }
            }
        }
        return -1;
    }
}
