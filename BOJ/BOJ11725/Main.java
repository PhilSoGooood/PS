package BOJ.BOJ11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] nodes = new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        int[] parent = new int[N+1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            for (int num : nodes[cur]) {
                if (parent[cur] == num) continue;
                parent[num] = cur;
                deque.add(num);
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i < N + 1; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
