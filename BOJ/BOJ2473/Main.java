package BOJ.BOJ2473;

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
        long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(nums);
        long min = Long.MAX_VALUE;
        long[] ans = new long[3];
        for (int i = 0; i < N-2; i++) {
            int st = i+1;
            int end = N-1;
            while (st < end) {
                long sum = nums[i] + nums[st] + nums[end];
                long absSum = Math.abs(sum);
                if (absSum <= min) {
                    min = absSum;
                    ans[0] = nums[i];
                    ans[1] = nums[st];
                    ans[2] = nums[end];
                }
                if (sum > 0) {
                    end--;
                } else {
                    st++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans[0] + " " + ans[1] + " " + ans[2]);
        bw.flush();
        bw.close();
        br.close();
   }
}
