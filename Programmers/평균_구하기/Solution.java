package Programmers.평균_구하기;

import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
