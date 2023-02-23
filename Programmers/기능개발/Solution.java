package Programmers.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count = 1;
        int standard = (int)Math.ceil((double)(100 - progresses[0]) / speeds[0]);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=1; i < speeds.length; i++) {
            int day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            if (day <= standard) {
                count++;
            } else {
                dq.add(count);
                count = 1;
                standard = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            }

            if (i == speeds.length - 1) dq.add(count);
        }
        int[] answer = new int[dq.size()];
        for (int i=0; i < answer.length; i++) {
            answer[i] = dq.pollFirst();
        }
        return answer;
    }
}
