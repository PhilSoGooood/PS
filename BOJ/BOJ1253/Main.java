package BOJ.BOJ1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int st = 0;
            int end = N - 1;
            while (st < end) {
                if (st == i) {
                    st++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                int sum = nums[st] + nums[end];
                if (sum == nums[i]) {
                    ans++;
                    break;
                }
                if (sum > nums[i]) end--;
                if (sum < nums[i]) st++;
            }
        }
        System.out.println(ans);
    }
}
