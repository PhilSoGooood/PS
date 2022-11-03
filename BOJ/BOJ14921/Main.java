package BOJ.BOJ14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = Integer.MAX_VALUE;
        int st = 0;
        int end= N-1;

        while (st < end) {
            int sum = nums[st] + nums[end];
            int absSum = Math.abs(sum);
            if (Math.abs(ans) > absSum) {
                ans = sum;
            }
            if (sum > 0) end--;
            else st++;
        }
        System.out.println(ans);
    }

}
