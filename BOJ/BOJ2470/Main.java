package BOJ.BOJ2470;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int st = 0;
        int en = N-1;
        int min = Integer.MAX_VALUE;
        int lIdx = 0;
        int rIdx = 0;
        while (st < en) {
            int sum = arr[st] + arr[en];
            int absSum = Math.abs(sum);
            if (min > absSum) {
                min = absSum;
                lIdx = st;
                rIdx = en;
            }
            if (sum > 0) en--;
            else st++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[lIdx] + " " + arr[rIdx]);
        bw.flush();
        bw.close();
    }

}
