package LeetCode.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char par = s.charAt(i);
            if (par == '(' || par == '{' || par == '[') {
                deque.add(par);
            } else if (!deque.isEmpty() && par == '}') {
                if (deque.peekLast() == '{') {
                    deque.pollLast();
                } else {
                    return false;
                }
            } else if (!deque.isEmpty() && par == ')') {
                if (deque.peekLast() == '(') {
                    deque.pollLast();
                } else {
                    return false;
                }
            } else if (!deque.isEmpty() && par == ']') {
                if (deque.peekLast() == '[') {
                    deque.pollLast();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (deque.isEmpty()) return true;
        return false;
    }
}
