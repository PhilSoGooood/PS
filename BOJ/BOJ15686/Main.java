package BOJ.BOJ15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] isUsedChick = new boolean[13];
    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        calculate(0, 0);
        System.out.println(answer);
    }

    private static void calculate(int k, int st) {
        if (k == M) {
            int result = 0;
            for (int[] home : homes) {
                int hX = home[0];
                int hY = home[1];
                int dist = Integer.MAX_VALUE;

                for (int j = 0; j < chickens.size(); j++) {
                    if (!isUsedChick[j]) continue;
                    int[] chicken = chickens.get(j);
                    int cX = chicken[0];
                    int cY = chicken[1];
                    dist = Math.min(dist, Math.abs(hX - cX) + Math.abs(hY - cY));
                }
                result += dist;
            }
            answer = Math.min(answer, result);
            return;
        }

        for (int j = st; j < chickens.size(); j++) {
            isUsedChick[j] = true;
            calculate(k + 1, j + 1);
            isUsedChick[j] = false;
        }
    }
}
