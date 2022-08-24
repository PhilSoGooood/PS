package LeetCode.valid_palindrome;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
	public boolean isPalindrome(String s) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char chr = s.charAt(i);
			if ('A' <= chr && chr <= 'Z') {
				list.add(Character.toLowerCase(chr));
			} else if ('a' <= chr && chr <= 'z') {
				list.add(chr);
			} else if (Character.isDigit(chr)) {
				list.add(chr);
			}
		}
		for (int i = 0; i < list.size() / 2; i++) {
			if (list.get(i) != list.get(list.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
