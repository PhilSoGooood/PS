package LeetCode.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagrams = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sorted = String.valueOf(chars);
			if (anagrams.containsKey(sorted)) {
				anagrams.get(sorted).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				anagrams.put(sorted, list);
			}
		}

		List<List<String>> result = new ArrayList<>();
		for (List<String> list : anagrams.values()) {
			result.add(list);
		}
		return result;
	}
}
