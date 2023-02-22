package Programmers.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int num : arr) {
            if (dq.isEmpty() || dq.peekLast() != num) dq.add(num);
        }
        int[] answer = new int[dq.size()];
        for (int i=0; i < answer.length; i++) {
            answer[i] = dq.pollFirst();
        }
        return answer;
    }
}
