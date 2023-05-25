package BOJ.BOJ15681;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static boolean[] visited;
    private static List<Integer>[] nodes;
    private static int[] subTreeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        visited = new boolean[N+1];
        subTreeCount = new int[N+1];
        nodes = new List[N+1];

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] UV = br.readLine().split(" ");
            int U = Integer.parseInt(UV[0]);
            int V = Integer.parseInt(UV[1]);
            nodes[U].add(V);
            nodes[V].add(U);
        }
        countSubtreeNode(R);

        while (Q-- > 0) {
            int subRoot = Integer.parseInt(br.readLine());
            bw.write(subTreeCount[subRoot] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int countSubtreeNode(int cur) {
        visited[cur] = true;

        for (int subNode : nodes[cur]) {
            if (visited[subNode]) continue;
            subTreeCount[cur] += countSubtreeNode(subNode);
        }
        subTreeCount[cur]++;
        return subTreeCount[cur];
    }
}
