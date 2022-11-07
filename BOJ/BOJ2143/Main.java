package BOJ.BOJ2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] nums1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] nums2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] dp1 = new long[n+1];
        long[] dp2 = new long[m+1];

        for (int i = 0; i < n; i++) {
            dp1[i+1] = dp1[i] + nums1[i];
        }
        for (int i = 0; i < m; i++) {
            dp2[i+1] = dp2[i] + nums2[i];
        }
        List<Long> list1 = new ArrayList<>();
        Map<Long, Integer> map = new HashMap();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                list1.add(dp1[i] - dp1[j]);
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                long part = dp2[i] - dp2[j];
                map.put(part, map.getOrDefault(part, 0) + 1);
            }
        }
        long ans = 0;
        for (long num : list1) {
            if (map.containsKey(T - num)) {
                ans += map.get(T - num);
            }
        }
        System.out.println(ans);
    }
}
