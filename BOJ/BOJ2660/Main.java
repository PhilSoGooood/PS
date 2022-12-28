package BOJ.BOJ2660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == -1 || y == -1) break;
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (i == k || j == k || i == j) continue;
                    if (arr[i][k] != 0 && arr[k][j] != 0) {
                        if (arr[i][j] == 0) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        } else {
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int minCnt = 0;
        int[] member = new int[N+1];
        for (int i = 1; i < N + 1; i++) {
            int point= 0;
            for (int j = 1; j < N + 1; j++) {
                if (i == j) continue;
                point = Math.max(point, arr[i][j]);
            }
            member[i] = point;
            if (point < min) {
                min = point;
                minCnt = 1;
            } else if (min == point) {
                minCnt++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(min + " " + minCnt + "\n");
        for (int i = 1; i < N + 1; i++) {
            if (min == member[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
