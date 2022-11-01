package BOJ.BOJ2467;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ansIdx1 = 0;
        int ansIdx2 = 0;
        int st = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;

        while (st < end) {
            int sum = arr[st] + arr[end];
            int absSum = Math.abs(sum);

            if (absSum <= min) {
                ansIdx1 = st;
                ansIdx2 = end;
                min = absSum;
            }

            if (sum < 0) {
                st++;
            } else {
                end--;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[ansIdx1] + " " + arr[ansIdx2]);
        bw.flush();
        bw.close();
        br.close();
    }

}

