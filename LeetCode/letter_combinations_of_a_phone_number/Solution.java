package LeetCode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final StringBuilder SB = new StringBuilder();
    private static final String[][] PHONE = new String[][] {{},{}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
        {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        btk(digits, 0, answer);
        return answer;
    }

    private void btk(String digits, int cur, List<String> answer) {
        if (digits.length() == 0) return;
        if (cur == digits.length()) {
            answer.add(SB.toString());
            return;
        }

        int num = (digits.charAt(cur)) - '0';

        for (int i=0; i < PHONE[num].length; i++) {
            SB.append(PHONE[num][i]);
            btk(digits, cur+1, answer);
            SB.deleteCharAt(cur);
        }
    }
}
