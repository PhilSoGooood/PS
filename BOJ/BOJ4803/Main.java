package BOJ.BOJ4803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String NO_TREE = "No trees.";
    private static final String ONE_TREE = "There is one tree.";
    private static final String FOREST = "A forest of ";
    private static final String TREES = " trees.";

    private static List<Integer>[] trees;
    private static boolean[] visit;
    private static boolean isTree;

    public static void main(String[] args) throws IOException {
        int tc = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            if (n == 0 && m == 0) break;
            visit = new boolean[n+1];
            trees = new List[n+1];

            for (int i=0; i < trees.length; i++) {
                trees[i] = new ArrayList<>();
            }

            for (int i=0; i < m; i++) {
                String[] ab = br.readLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                trees[a].add(b);
                trees[b].add(a);
            }

            int answer = 0;

            for (int i=1; i < n+1; i++) {
                if (visit[i]) continue;
                visit[i] = true;
                isTree = true;
                dfs(i, -1);
                if (isTree) answer++;
            }

            sb.append("Case " + tc++ + ": ");

            if (answer == 0) {
                sb.append(NO_TREE);
            } else if (answer == 1) {
                sb.append(ONE_TREE);
            } else {
                sb.append(FOREST + answer + TREES);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int prev) {
        for (int next : trees[cur]) {
            if (next == prev) continue;
            if (visit[next]) {
                isTree = false;
                continue;
            }
            visit[next] = true;
            dfs(next, cur);
        }
    }
}
