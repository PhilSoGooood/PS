package BOJ.BOJ1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE >> 1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A-1][B-1] = 1;
            arr[B-1][A-1] = 1;
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || i == k) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int kevinNum = Integer.MAX_VALUE;
        int kevin = 0;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                sum += arr[i][j];
            }
            arr[i][i] = sum;
            if (sum < kevinNum) {
                kevinNum = sum;
                kevin = i+1;
            }
        }

        System.out.println(kevin);
    }
}
