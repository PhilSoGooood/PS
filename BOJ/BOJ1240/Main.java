package BOJ.BOJ1240;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        List<int[]>[] board = new List[N+1];

        for (int i = 0; i < N + 1; i++) {
             board[i] = new ArrayList<>();
        }

        for (int i=0; i < N-1; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            board[x].add(new int[] {y, dist});
            board[y].add(new int[] {x, dist});
        }

        while (M-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            Deque<int[]> dq = new ArrayDeque<>();
            boolean[] visit = new boolean[N+1];

            dq.add(new int[] {st, 0});
            visit[st] = true;

            while (!dq.isEmpty()) {
                int[] cur = dq.pollFirst();
                int curNum = cur[0];
                int curDist = cur[1];

                if (curNum == end) {
                    bw.write(cur[1] + "\n");
                    break;
                }

                for (int[] next : board[cur[0]]) {
                    int nextNum = next[0];
                    int nextDist = next[1];
                    if (visit[nextNum]) continue;
                    visit[nextNum] = true;
                    dq.add(new int[] {nextNum, curDist + nextDist});
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
