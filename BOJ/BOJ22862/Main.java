package BOJ.BOJ22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int en = 0;
        int cnt = 0;
        int ans = 0;
        if (nums[0] % 2 == 1) cnt++;
        for (int st = 0; st < N; st++) {
            while (en < N-1 && cnt <= K) {
               if (nums[en+1] % 2 == 1) cnt++;
               en++;
            }
            if (en - st - cnt + 1 > ans) ans = en - st - cnt + 1;
            if (nums[st] % 2 == 1) cnt--;
        }
        System.out.println(ans);
    }
}
