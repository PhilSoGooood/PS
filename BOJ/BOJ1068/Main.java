package BOJ.BOJ1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N];
        List[] children = new List[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<Integer>();
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(input[i]);
            parents[i] = parent;
            if (parent == -1)  continue;
            children[parent].add(i);
        }
        int M = Integer.parseInt(br.readLine());
        int mParent = parents[M];
        if (mParent != -1) {
            children[mParent].remove((Integer)M);
        }
        dfs(M, children, parents, M);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (i == M || parents[i] == M) continue;
            if (children[i].isEmpty()) ans++;
        }
        System.out.println(ans);
    }

    private static void dfs(int cur, List[] children, int[] parents, int M) {
        List<Integer> child = children[cur];
        for (int num : child) {
            parents[num] = M;
            dfs(num, children, parents, M);
        }
    }
}
