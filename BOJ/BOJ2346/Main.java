package BOJ.BOJ2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int cur = 0;
        int move= arr[0];
        arr[0] = 0;
        sb.append(1).append(" ");
        while (true) {
            if (move < 0) {
                while (move < 0) {
                    if (cur == 0) cur = N;
                    if (arr[cur-1] != 0) {
                        move++;
                    }
                    cur--;
                }
            } else {
                while (0 < move) {
                    if (cur == N-1) cur = -1;
                    if (arr[cur+1] != 0) {
                        move--;
                    }
                    cur++;
                }
            }
            sb.append(cur + 1).append(" ");
            cnt++;
            if (cnt == N) break;
            move = arr[cur];
            arr[cur] = 0;
        }
        System.out.println(sb);
    }
}
