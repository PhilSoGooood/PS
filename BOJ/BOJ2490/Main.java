package BOJ.BOJ2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static String solution(String[] sticks){
		int count = 0;
		for(String stick : sticks){
			if(stick.equals("1")) count++;
		}

		if(count == 0){return "D";}
		else if(count == 1){return "C";}
		else if(count == 2){return "B";}
		else if(count == 3){return "A";}
		return "E";
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<3; i++){
			String[] sticks = br.readLine().split(" ");
			System.out.println(solution(sticks));
		}
	}
}
