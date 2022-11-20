package BOJ.BOJ16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long A = Long.parseLong(stk.nextToken());
        long B = Long.parseLong(stk.nextToken());

        Map<Long, Long> map = new HashMap<>();
        Queue<Long> Q = new ArrayDeque<>();

        map.put(A, 0L);
        Q.add(A);
        while (!Q.isEmpty()) {
            long cur = Q.poll();

            long tmp = cur * 2;
            if (tmp <= B) {
                if (!map.containsKey(tmp)) {
                    map.put(tmp, map.get(cur) + 1);
                } else {
                    map.put(tmp, Math.min(map.get(cur) + 1, map.get(tmp)));
                }
                Q.add(tmp);
            }
            tmp = cur * 10 + 1;
            if (tmp <= B) {
                if (!map.containsKey(tmp)) {
                    map.put(tmp, map.get(cur) + 1);
                } else {
                    map.put(tmp, Math.min(map.get(cur) + 1, map.get(tmp)));
                }
                Q.add(tmp);
            }
        }
        if (map.containsKey(B)) {
            System.out.println(map.get(B) + 1);
        } else {
            System.out.println(-1);
        }
    }
}
