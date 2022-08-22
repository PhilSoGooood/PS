package LeetCode.reverse_string;

class Solution1 {
	public void reverseString(char[] s) {
		int start = 0;
		int end = s.length - 1;

		while (start < end) {
			char tmp = s[end];
			s[end] = s[start];
			s[start] = tmp;
			start++;
			end--;
		}
	}
}
