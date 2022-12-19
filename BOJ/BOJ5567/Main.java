package BOJ.BOJ5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int[] visit = new int[n+1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            if (arr[1][i] == 0) continue;
            if (visit[i] == 0) {
                ans++;
                visit[i] = 1;
            }
            for (int j = 2; j < n+1; j++) {
                if (i == j || arr[i][j] == 0 || visit[j] == 1) continue;
                ans++;
                visit[j] = 1;
            }
        }
        System.out.println(ans);
    }
}
