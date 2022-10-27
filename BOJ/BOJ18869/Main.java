package BOJ.BOJ18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] universes = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int[] sorted = new int[N];
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                sorted[j] = num;
            }
            Arrays.sort(sorted);
            Map<Integer, Integer> index = new HashMap<>();

            int idx = 0;
            for (int num : sorted) {
                if (index.containsKey(num)) continue;
                index.put(num, idx++);
            }
            for (int j = 0; j < N; j++) {
                universes[i][j] = index.get(arr[j]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (isSame(universes[i], universes[j], N)) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isSame(int[] a, int[] b, int N) {
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
