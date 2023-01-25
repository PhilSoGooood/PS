package Programmers.최댓값과_최솟값;

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[arr.length-1]);
        return sb.toString();
    }
}
