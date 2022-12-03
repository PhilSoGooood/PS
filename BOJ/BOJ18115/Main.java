package BOJ.BOJ18115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> dq = new ArrayDeque<>();
        int num = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                dq.addFirst(num++);
            } else if (arr[i] == 2) {
                int tmp = dq.pollFirst();
                dq.addFirst(num++);
                dq.addFirst(tmp);
            } else {
                dq.addLast(num++);
            }
        }
        while (!dq.isEmpty()) {
            bw.write(dq.pollFirst() + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
