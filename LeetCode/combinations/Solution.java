package LeetCode.combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        btk(1, n, k, nums);
        return answer;
    }

    public void btk(int cur, int n, int k, List<Integer> nums) {
        if (k == 0) {
            answer.add(List.copyOf(nums));
            return;
        }

        for (int i=cur; i <= n; i++) {
            nums.add(i);
            btk(i+1, n, k-1, nums);
            nums.remove((Integer)i);
        }
    }
}
