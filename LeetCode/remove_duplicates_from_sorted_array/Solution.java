package LeetCode.remove_duplicates_from_sorted_array;

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i=1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) continue;
            nums[k++] = nums[i];
        }
        return k;
    }
}
