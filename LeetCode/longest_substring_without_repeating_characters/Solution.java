package LeetCode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIdxMap = new HashMap<>();
        int answer = 0;
        int st = 0;
        int cur = 0;
        while (cur < s.length()) {
            char part = s.charAt(cur);
            if (charIdxMap.containsKey(part) && charIdxMap.get(part) > st) {
                answer = Math.max(answer, cur - st);
                st = charIdxMap.get(part) + 1;
            }
            charIdxMap.put(part, cur);
            cur++;
        }
        answer = Math.max(answer, cur - st);
        return answer;
    }
}
