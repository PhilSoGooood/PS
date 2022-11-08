package BOJ.BOJ2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int end = 0;
        for (int st = 0; st < N; st++) {
            while (end < N && nums[end] - nums[st] < M) end++;
            if (end == N) break;
            ans = Math.min(ans, nums[end] - nums[st]);
        }
        System.out.println(ans);
    }
}
