package LeetCode.longest_palindromic_substring;

class Solution {

	public static String longestPalindrome(String s) {
		String result = "";
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 2)) {
				int x = i;
				int y = i + 2;
				while (x >= 0 && y <= s.length() - 1) {
					if (x == 0 || y == s.length() - 1)
						break;
					if (s.charAt(x - 1) != s.charAt(y + 1))
						break;
					x--;
					y++;
				}
				String palindrome = s.substring(x, y + 1);
				if (result.length() < palindrome.length()) {
					result = palindrome;
				}
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				int x = i;
				int y = i + 1;
				while (x >= 0 && y <= s.length() - 1) {
					if (x == 0 || y == s.length() - 1)
						break;
					if (s.charAt(x - 1) != s.charAt(y + 1))
						break;
					x--;
					y++;
				}
				String palindrome = s.substring(x, y + 1);
				if (result.length() < palindrome.length()) {
					result = palindrome;
				}
			}
		}
		if (result.length() == 0) {
			return s.substring(0, 1);
		}
		return result;
	}
}
