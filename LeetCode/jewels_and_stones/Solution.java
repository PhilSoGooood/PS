package LeetCode.jewels_and_stones;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneCount = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            stoneCount.put(stone, stoneCount.getOrDefault(stone, 0) + 1);
        }

        int answer = 0;

        for (int i = 0; i < jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            answer += stoneCount.getOrDefault(jewel, 0);
        }

        return answer;
    }
}
