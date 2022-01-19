package Programmers.모의고사;

import java.util.ArrayList;

public class Solution {
	public static int[] solution(int[] answers) {
		int[] correct = new int[3];
		ArrayList<Integer> list = new ArrayList<>();

		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for(int i=0; i<answers.length; i++){
			if(answers[i] == student1[i % student1.length]) correct[0]++;
			if(answers[i] == student2[i % student2.length]) correct[1]++;
			if(answers[i] == student3[i % student3.length]) correct[2]++;
		}
		int max = Math.max(correct[0], Math.max(correct[1], correct[2]));

		for(int i=0; i<3; i++){
			if(correct[i] == max){
				list.add(i+1);
			}
		}

		int[] answer = new int[list.size()];
		for(int i=0; i<answer.length; i++){
			answer[i] = list.get(i);
		}
		return answer;
	}
}