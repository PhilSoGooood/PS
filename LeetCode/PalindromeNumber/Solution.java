package LeetCode.PalindromeNumber;

class Solution {
	public boolean isPalindrome(int x) {
		boolean result = false;
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		if(Integer.toString(x).equals(sb.reverse().toString()))
			result = true;

		return result;
	}
}