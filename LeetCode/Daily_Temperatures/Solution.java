package LeetCode.Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int num = temperatures[i];
            while (!dq.isEmpty() && num > temperatures[dq.peekLast()]) {
                int idx = dq.pollLast();
                ans[idx] = i - idx;
            }
            dq.add(i);
        }
        return ans;
    }
}
