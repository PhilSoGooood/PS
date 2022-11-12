package BOJ.BOJ13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int en = 0;
        long ans = 0;
        boolean[] check = new boolean[N+1];
        check[nums[0]] = true;
        for (int st = 0; st < N; st++) {
            while (en < N-1 && !check[nums[en+1]]) {
                en++;
                check[nums[en]] = true;
            }
            ans += (en - st + 1);
            check[nums[st]] = false;
        }
        System.out.println(ans);
    }
}
