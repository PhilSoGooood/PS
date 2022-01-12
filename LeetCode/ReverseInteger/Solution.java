package LeetCode.ReverseInteger;

class Solution {
	public int reverse(int x) {
		StringBuilder sb = new StringBuilder();

		if(x==Integer.MIN_VALUE) sb.append((long)(Integer.MAX_VALUE)+1);
		else sb.append(Math.abs(x));

		long result = Long.parseLong(sb.reverse().toString());
		int maxInt = (int)(Math.pow(2, 31)-1);
		if(result > maxInt || -result < -maxInt-1){
			return 0;
		}
		if(x >= 0) return (int)result;

		return (int)-result;
	}
}
