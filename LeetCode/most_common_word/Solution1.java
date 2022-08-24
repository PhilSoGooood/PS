package LeetCode.most_common_word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {
	public static String mostCommonWord(String paragraph, String[] banned) {
		List<String> bannedWords = Arrays.asList(banned);

		String[] split = paragraph.toLowerCase().split("[ |!|\\?|'|,|;|.]");
		String[] arr = Arrays.stream(split)
			.filter(s -> !bannedWords.contains(s))
			.filter(s -> !s.equals(""))
			.toArray(String[]::new);
		Map<String, Integer> count = new HashMap<>();
		for (String s : arr) {
			count.put(s, count.getOrDefault(s, 0)+1);
		}
		int cnt = 0;
		String result = "";

		for (String s : arr) {
			if (count.get(s) > cnt) {
				cnt = count.get(s);
				result = s;
			}
		}
		return result;
	}
}
