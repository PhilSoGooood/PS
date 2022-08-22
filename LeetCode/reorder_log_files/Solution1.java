package LeetCode.reorder_log_files;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution1 {
	public String[] reorderLogFiles(String[] logs) {
		Deque<String> digits = new LinkedList<>();
		Deque<String> letters = new LinkedList<>();
		for (String log : logs) {
			if (Character.isDigit(log.split(" ")[1].charAt(0))) {
				digits.add(log);
			} else {
				letters.add(log);
			}
		}
		String[] letterArr = new String[letters.size()];
		for (int i = 0; i < letterArr.length; i++) {
			letterArr[i] = letters.pollFirst();
		}
		Arrays.sort(letterArr, (o1, o2) -> {
			int space1 = o1.indexOf(" ");
			int space2 = o2.indexOf(" ");
			String s1 = o1.substring(space1 + 1);
			String s2 = o2.substring(space2 + 1);
			int result = s1.compareTo(s2);
			if (result == 0) {
				return o1.substring(0, space1).compareTo(o2.substring(0, space2));
			}
			return result;
		});
		int lettersLen = letterArr.length;
		String[] result = Arrays.copyOf(letterArr, logs.length);
		for (int i = lettersLen; i < result.length; i++) {
			result[i] = digits.pollFirst();
		}
		return result;
	}
}
