package Programmers.이상한_문자_만들기;


public class Solution {
	public static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		boolean check = false;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == ' '){
				answer.append(" ");
				check = false;
			} else if(!check){
				answer.append(Character.toString(s.charAt(i)).toUpperCase());
				check = true;
			} else {
				answer.append(Character.toString(s.charAt(i)).toLowerCase());
				check = false;
			}
		}
		return answer.toString();
	}
}