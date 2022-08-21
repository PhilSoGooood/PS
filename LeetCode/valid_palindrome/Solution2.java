package LeetCode.valid_palindrome;

import java.util.Deque;
import java.util.LinkedList;

class Solution2 {
	public boolean isPalindrome(String s) {
		Deque<Character> deque = new LinkedList<>();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			char chr = s.charAt(i);
			if (('a' <= chr && chr <= 'z') || ('0' <= chr && chr <= '9')) {
				deque.add(chr);
			}
		}
		while (deque.size() > 1) {
			if (deque.pollFirst() != deque.pollLast()) return false;
		}
		return true;
	}
}
