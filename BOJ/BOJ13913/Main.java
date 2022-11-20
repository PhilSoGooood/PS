package BOJ.BOJ13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // arr[위치][시간, 이전 위치]
        int[][] arr = new int[100001][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = Integer.MAX_VALUE;
        }
        Queue<Integer> Q = new LinkedList<>();
        arr[N][0] = 0;
        Q.add(N);
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            if (cur + 1 <= 100000 && arr[cur][0] + 1 < arr[cur + 1][0]) {
                arr[cur + 1][0] = arr[cur][0] + 1;
                arr[cur + 1][1] = cur;
                Q.add(cur + 1);
            }
            if (cur - 1 >= 0 && arr[cur][0] + 1 < arr[cur - 1][0]) {
                arr[cur - 1][0] = arr[cur][0] + 1;
                arr[cur - 1][1] = cur;
                Q.add(cur - 1);
            }
            if (cur * 2 <= 100000 && arr[cur][0] + 1 < arr[cur * 2][0]) {
                arr[cur * 2][0] = arr[cur][0] + 1;
                arr[cur * 2][1] = cur;
                Q.add(cur * 2);
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int i = K;
        while (true) {
            dq.add(i);
            if (i == N) {
                break;
            }
            i = arr[i][1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[K][0] + "\n");

        while (!dq.isEmpty()) {
            sb.append(dq.pollLast() + " ");
        }

        System.out.println(sb);
    }
}
