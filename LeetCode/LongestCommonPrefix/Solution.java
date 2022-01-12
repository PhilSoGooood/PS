package LeetCode.LongestCommonPrefix;

import java.util.Arrays;

class Solution {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();

		// 문자의 인덱스
		int idx = 0;

		loop:
		while(true){
			for(String str : strs){
				if(str.equals("")) break loop;
				if(idx >= str.length()) break loop;
				if(strs[0].charAt(idx) != str.charAt(idx)) break loop;
			}
			sb.append(strs[0].charAt(idx));
			idx++;
		}
		return sb.toString();
	}
}