package BOJ.BOJ2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = new int[NM[0]];
        for (int i = 0; i < NM[0]; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int cur = NM[0] - 1;
        for (int i = NM[0] - 1; i > 0; i--) {
            int gap = nums[i] - nums[cur];
            while (gap < NM[1] && cur > 0) {
                cur--;
                gap = nums[i] - nums[cur];
            }
            gap = nums[i] - nums[cur];
            if (NM[1] <= gap && gap < ans) {
                ans = gap;
            }
        }
        System.out.println(ans);
    }
}
