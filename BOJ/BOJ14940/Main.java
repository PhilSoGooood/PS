package BOJ.BOJ14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] st = new int[2];

        for (int i=0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j < m; j++) {
                int num = Integer.parseInt(line[j]);
                board[i][j] = num;
                if (num == 2) {
                    st[0] = i;
                    st[1] = j;
                }
            }
        }
        board[st[0]][st[1]] = 0;
        visited[st[0]][st[1]] = true;
        dq.add(st);

        while (!dq.isEmpty()) {
            int[] location = dq.pollFirst();
            int x = location[0];
            int y = location[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] != 1) continue;
                if (visited[nx][ny]) continue;
                board[nx][ny] = board[x][y] + 1;
                visited[nx][ny] = true;
                dq.add(new int[]{nx, ny});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    board[i][j] = -1;
                }
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
