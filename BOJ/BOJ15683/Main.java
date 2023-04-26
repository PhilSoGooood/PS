package BOJ.BOJ15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] map;
    private static int[][] board;
    private static final List<int[]> cctv = new ArrayList<>();
    private static int answer = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new int[N][M];
        board = new int[N][M];

        for (int i=0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j < M; j++) {
                int num = Integer.parseInt(input[j]);
                map[i][j] = num;
                if (0 < num && num < 6) cctv.add(new int[] {i, j});
                if (num == 0) answer++;
            }
        }

        for (int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++) {
            for (int i=0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    board[i][j] = map[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;

                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                int camera = map[x][y];
                
                if (camera == 1) {
                    check(x, y, dir);
                } else if (camera == 2) {
                    check(x, y, dir);
                    check(x, y, dir+2);
                } else if (camera == 3) {
                    check(x, y, dir);
                    check(x, y, dir + 1);
                } else if (camera == 4) {
                    check(x, y, dir);
                    check(x, y, dir+1);
                    check(x, y, dir+2);
                } else if (camera == 5) {
                    check(x, y, dir);
                    check(x, y, dir+1);
                    check(x, y, dir+2);
                    check(x, y, dir+3);
                }
            }
            answer = Math.min(answer, count());
        }
        System.out.println(answer);
    }

    private static void check(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (isOutOfBound(x, y) || map[x][y] == 6) return;
            if (map[x][y] != 0) continue;
            board[x][y] = 7;
        }
    }

    private static boolean isOutOfBound(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
