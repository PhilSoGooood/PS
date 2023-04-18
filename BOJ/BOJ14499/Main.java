package BOJ.BOJ14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int x;
    private static int y;
    private static int[] nDice;
    private static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            int dir = Integer.parseInt(st.nextToken());
            if (dir == 1 && y == M-1) continue;
            if (dir == 2 && y == 0) continue;
            if (dir == 3 && x == 0) continue;
            if (dir == 4 && x == N-1) continue;
            go(dir);
            dice = nDice;
            sb.append(dice[5]).append("\n");

            if (map[x][y] == 0) {
                map[x][y] = dice[0];
            } else {
                dice[0] = map[x][y];
                map[x][y] = 0;
            }
        }
        System.out.println(sb);
    }

    private static void go(int dir) {
        if (dir == 1) goEast();
        else if (dir == 2) goWest();
        else if (dir == 3) goNorth();
        else goSouth();
    }

    private static void goNorth() {
        x-=1;
        nDice = new int[6];
        nDice[0] = dice[1];
        nDice[1] = dice[5];
        nDice[2] = dice[2];
        nDice[3] = dice[3];
        nDice[4] = dice[0];
        nDice[5] = dice[4];
    }

    private static void goSouth() {
        x+=1;
        nDice = new int[6];
        nDice[0] = dice[4];
        nDice[1] = dice[0];
        nDice[2] = dice[2];
        nDice[3] = dice[3];
        nDice[4] = dice[5];
        nDice[5] = dice[1];
    }

    private static void goWest() {
        y-=1;
        nDice = new int[6];
        nDice[0] = dice[3];
        nDice[1] = dice[1];
        nDice[2] = dice[0];
        nDice[3] = dice[5];
        nDice[4] = dice[4];
        nDice[5] = dice[2];
    }

    private static void goEast() {
        y+=1;
        nDice = new int[6];
        nDice[0] = dice[2];
        nDice[1] = dice[1];
        nDice[2] = dice[5];
        nDice[3] = dice[0];
        nDice[4] = dice[4];
        nDice[5] = dice[3];
    }
}
