package Programmers.모의고사;

import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		int[] count = new int[3];
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for (int i=0; i<answers.length; i++) {
			int answer = answers[i];
			if (student1[i % student1.length] == answer) count[0]++;
			if (student2[i % student2.length] == answer) count[1]++;
			if (student3[i % student3.length] == answer) count[2]++;
		}

		int max = 0;
		for (int i=0; i < 3; i++) {
			if (count[i] > max) max = count[i];
		}
		List<Integer> list = new ArrayList<>();
		for (int i=0; i < 3; i++) {
			if (count[i] == max) list.add(i+1);
		}
		return list.stream().mapToInt(Integer::valueOf).toArray();
	}
}
