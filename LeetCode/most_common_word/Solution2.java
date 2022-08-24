package LeetCode.most_common_word;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

	public static String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> bannedMap = new HashMap<>();
		for (String s : banned) {
			bannedMap.put(s, 1);
		}
		paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9]", " ");
		String[] words = paragraph.split("\\s+");
		Map<String, Integer> count = new HashMap<>();
		for (String word : words) {
			if (!bannedMap.containsKey(word)) {
				count.put(word, count.getOrDefault(word, 0) + 1);
			}
		}
		int cnt = 0;
		String result = "";

		for (String s : count.keySet()) {
			if (count.get(s) > cnt) {
				cnt = count.get(s);
				result = s;
			}
		}
		return result;
	}
}
