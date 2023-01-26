package Programmers.올바른_괄호;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.add(s.charAt(i));
            } else {
                if (!dq.isEmpty() && dq.peekLast() == '(') {
                    dq.pollLast();
                } else {
                    return false;
                }
            }
        }
        return dq.isEmpty();
    }
}

