package BOJ.BOJ11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ11655 ROT13
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<input.length(); i++){
			char chr = input.charAt(i);
			if('A' <= chr && chr <= 'Z'){
				if((char)(chr + 13) > (int)'Z'){
					sb.append((char)(chr - 13));
				} else {
					sb.append((char)(chr + 13));
				}
			} else if('a' <= chr && chr <= 'z'){
				if((char)(chr + 13) > (int)'z'){
					sb.append((char)(chr - 13));
				} else {
					sb.append((char)(chr + 13));
				}
			} else {
				sb.append(chr);
			}
		}
		System.out.println(sb.toString());
	}
}
