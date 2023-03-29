package BOJ.BOJ6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        List<Integer>[] list = new List[N+1];
        for (int i=1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            String[] split = br.readLine().split(" ");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);
            list[A].add(B);
            list[B].add(A);
        }
        System.out.println(bfs(list, N));
    }

    private static String bfs(List<Integer>[] list, int N) {
        int[] distance = new int[N+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        int maxDist = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            List<Integer> curList = list[cur];
            for (int next : curList) {
                if (distance[next] != -1) continue;
                distance[next] = distance[cur] + 1;
                maxDist = Math.max(distance[next], maxDist);
                dq.add(next);
            }
        }

        int count = 0;
        int idx = 0;

        for (int i=2; i < N+1; i++) {
            if (distance[i] == maxDist) {
                if (count == 0) idx = i;
                count++;
            }
        }
        return idx + " " + maxDist + " " + count;
    }
}
