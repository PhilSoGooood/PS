package BOJ.BOJ3151;

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
        long ans = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                break;
            }
            int st = i + 1;
            int end = N - 1;
            while (st < end) {
                int sum = nums[i] + nums[st] + nums[end];
                if (sum == 0) {
                    int leftCnt = 1;
                    int rightCnt = 1;
                    if (nums[st] == nums[end]) {
                        ans += comb(end - st + 1);
                        break;
                    }
                    while (st + 1 < end && nums[st] == nums[st + 1]) {
                        leftCnt++;
                        st++;
                    }

                    while (end - 1 > st && nums[end] == nums[end - 1]) {
                        rightCnt++;
                        end--;
                    }

                    ans += (long) leftCnt * rightCnt;
                }
                if (sum > 0) {
                    end--;
                } else {
                    st++;
                }
            }
        }
        System.out.println(ans);
    }

    private static long comb(int n) {
        return (long) n * (n - 1) / 2;
    }
}


