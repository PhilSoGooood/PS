package BOJ.BOJ1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[N+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[N+1];
        boolean[] visited;


        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        int mx = 0;

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dq.add(i);

            while (!dq.isEmpty()) {
                int num = dq.pollFirst();
                result[num]++;
                visited[num] = true;
                mx = Math.max(mx, result[num]);
                for (int nxt : graph[num]) {
                    if (visited[nxt]) continue;
                    visited[nxt] = true;
                    dq.add(nxt);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < N + 1; i++) {
            if (result[i] == mx) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
