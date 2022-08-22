package LeetCode.reorder_log_files;

import java.util.Arrays;
import java.util.Comparator;

class Solution2 {
	public String[] reorderLogFiles(String[] logs) {
		Comparator<String> comparator = (o1, o2) -> {
			String[] s1 = o1.split(" ", 2);
			String[] s2 = o2.split(" ", 2);

			boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(s2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				if (s1[1].compareTo(s2[1]) == 0) {
					return s1[0].compareTo(s2[0]);
				} else {
					return s1[1].compareTo(s2[1]);
				}
			}
			if (!isDigit1 && isDigit2) {
				return -1;
			}

			if (isDigit1 && !isDigit2) {
				return 1;
			}

			return 0;
		};
		Arrays.sort(logs, comparator);
		return logs;
	}
}
