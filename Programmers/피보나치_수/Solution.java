package Programmers.피보나치_수;

class Solution {
    public int solution(int n) {
        return fibo(n);
    }

    private int fibo(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i-1] % 1234567 + arr[i-2] % 1234567;
        }
        return arr[n] % 1234567;
    }
}
