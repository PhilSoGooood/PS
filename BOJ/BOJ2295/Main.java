package BOJ.BOJ2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                map.put(nums[i] + nums[j], 1);
            }
        }
        System.out.println(search(N, nums, map));

    }

    private static int search(int N, int[] nums, Map<Integer, Integer> map) {
        for (int i = N - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(nums[i] - nums[j])) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
