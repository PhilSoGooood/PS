package BOJ.BOJ12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N+1];
        int[] value = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weight[i] = w;
            value[i] = v;
        }
        System.out.println(knapsack(N, K, weight, value));
    }

    private static int knapsack(int N, int K, int[] weight, int[] value) {
        int[][] arr = new int[N+1][K+1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (weight[i] > j) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(value[i] + arr[i-1][j - weight[i]], arr[i-1][j]);
                }
            }
        }
        return arr[N][K];
    }
}
