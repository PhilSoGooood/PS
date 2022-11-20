package BOJ.BOJ12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int[] dist = new int[100001];
        int[] visit = new int[100001];
        Arrays.fill(dist, 100001);
        dist[N] = 0;
        visit[N] = 1;
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(N);

        while (!Q.isEmpty()) {
            int cur = Q.pollFirst();
            if (cur + 1 < 100001 && dist[cur + 1] >= dist[cur] + 1) {
                dist[cur+1] = dist[cur] + 1;
                Q.add(cur + 1);
                if (dist[cur + 1] < dist[cur] + 1) visit[cur + 1] = 1;
                else visit[cur+1]++;
            }
            if (0 <= cur - 1 && dist[cur - 1] >= dist[cur] + 1) {
                dist[cur-1] = dist[cur] + 1;
                Q.add(cur - 1);
                if (dist[cur - 1] < dist[cur] + 1) visit[cur - 1] = 1;
                else visit[cur-1]++;
            }
            if (cur * 2 < 100001 && dist[cur * 2] >= dist[cur] + 1) {
                dist[cur*2] = dist[cur] + 1;
                Q.add(cur * 2);
                if (dist[cur * 2] < dist[cur] + 1) visit[cur * 2] = 1;
                else visit[cur*2]++;
            }
        }
        System.out.println(dist[K]);
        System.out.println(visit[K]);
    }
}
