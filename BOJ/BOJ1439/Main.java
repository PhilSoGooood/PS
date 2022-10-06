package BOJ.BOJ1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int switchNum = 0;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i-1) != input.charAt(i)) switchNum++;
		}
		if (switchNum % 2 == 1) {
			switchNum++;
		}
		System.out.println(switchNum / 2);
	}
}
