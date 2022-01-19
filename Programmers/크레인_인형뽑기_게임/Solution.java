package Programmers.크레인_인형뽑기_게임;

import java.util.Stack;

public class Solution {
	public int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;

		for(int move : moves){
			for(int row = 0; row<board.length; row++){
				if(board[row][move-1] != 0){
					if(!stack.isEmpty() && stack.peek() == board[row][move-1]){
						stack.pop();
						answer += 2;
					} else {
						stack.add(board[row][move-1]);
					}
					board[row][move-1] = 0;
					break;
				}
			}
		}

		return answer;
	}
}
