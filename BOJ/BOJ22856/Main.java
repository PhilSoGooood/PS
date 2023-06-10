package BOJ.BOJ22856;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // root, a, b
        int[][] nodes = new int[N+1][3];
        boolean[] visited = new boolean[N+1];
        for (int i=0; i < N; i++)  {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            nodes[parent][1] = a;
            nodes[parent][2] = b;
            if (a == -1) continue;
            nodes[a][0] = parent;
            if (b == -1) continue;
            nodes[b][0] = parent;
        }
        int answer = 0;
        int end = 1;
        while (nodes[end][2] != -1) {
            end = nodes[end][2];
        }
        int cur = 1;
        while (true) {
            visited[cur] = true;
            answer++;
            int a = nodes[cur][1];
            int b = nodes[cur][2];
            if (a != -1 && !visited[a]) {
                cur = a;
            } else if (b != -1 && !visited[b]) {
                cur = b;
            } else {
                if (cur == end) break;
                cur = nodes[cur][0];
            }
        }
        System.out.println(answer-1);
    }
}
