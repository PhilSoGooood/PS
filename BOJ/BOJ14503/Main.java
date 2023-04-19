package BOJ.BOJ14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[][] map = new int[N][M];

        // 0, 1, 2, 3 = 북, 동, 남, 서
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[r][c] = 2;
        answer++;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r, c, d});
        while (!dq.isEmpty()) {
            int[] location = dq.pollLast();
            int x = location[0];
            int y = location[1];
            int z = location[2];

            for (int i=1; i < 5; i++) {
                int nz = (4 + (z - i) % 4) % 4;
                int nx = x + dir[nz][0];
                int ny = y + dir[nz][1];

                if (nx < 0 || N <= nx || ny >= M || ny < 0) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    answer++;
                    dq.add(new int[]{nx, ny, nz});
                    break;
                }
            }

            if (dq.isEmpty()) {
                int nx = x + dir[(z + 2) % 4][0];
                int ny = y + dir[(z + 2) % 4][1];

                if (map[nx][ny] != 1) dq.add(new int[]{nx, ny, z});
            }
        }
        System.out.println(answer);
    }
}
