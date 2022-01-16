package BOJ.BOJ10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(String input) {
		int lowerCase = 0, upperCase = 0, number = 0, blank = 0;
		for(int i=0; i<input.length(); i++){
			if('a' <= input.charAt(i) && input.charAt(i) <= 'z'){
				lowerCase++;
			} else if('A' <= input.charAt(i) && input.charAt(i) <= 'Z'){
				upperCase++;
			} else if('0' <= input.charAt(i) && input.charAt(i) <= '9'){
				number++;
			} else blank++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(lowerCase + " ");
		sb.append(upperCase + " ");
		sb.append(number + " ");
		sb.append(blank);
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine())!=null){
			solution(input);
		}
	}
}
