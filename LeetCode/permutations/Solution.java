package LeetCode.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(permutation, nums, visited);
        return answer;
    }

    private void dfs(List<Integer> permutation, int[] nums, boolean[] visited) {
        if (permutation.size() == nums.length) {
            answer.add(List.copyOf(permutation));
        }
        for (int i=0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(permutation, nums, visited);
            visited[i] = false;
            permutation.remove((Integer) nums[i]);
        }
    }
}
