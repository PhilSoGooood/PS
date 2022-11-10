package BOJ.BOJ2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] nums = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        long sum=0;
        int cnt = 0;
        int en = 0;
        for (int st = 0; st < N; st++) {
            while (en < N && sum < M) {
                sum += nums[en];
                en++;
            }
            if (sum == M) cnt++;
            sum -= nums[st];
        }
        System.out.println(cnt);
    }
}
