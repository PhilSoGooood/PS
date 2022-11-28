package BOJ.BOJ23326;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                treeSet.add(i);
            }
        }
        int cur = 1;
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 1) {
                int i = Integer.parseInt(st.nextToken());
                if (treeSet.contains(i)) {
                    treeSet.remove(i);
                } else {
                    treeSet.add(i);
                }
            } else if (query == 2) {
                int x = Integer.parseInt(st.nextToken());
                cur = (cur + x) % N;
                if (cur == 0) cur = N;
            } else if (query == 3) {
                if (treeSet.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    Integer higher = treeSet.higher(cur - 1);
                    if (higher != null) {
                        bw.write(higher - cur + "\n");
                    } else {
                        bw.write(N - cur + treeSet.first() + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

