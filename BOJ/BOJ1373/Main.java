package BOJ.BOJ1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ1373 2진수 8진수
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String binary = br.readLine();
		StringBuilder sb = new StringBuilder();
		int exo = 1;
		int tmp = 0;
		for(int i=binary.length()-1; i>=0; i--){
			tmp += (binary.charAt(i) - '0') * exo;
			if(exo == 4){
				exo = 1;
				sb.append(tmp);
				tmp = 0;
			}
			else exo *= 2;
		}
		if(tmp > 0)
			sb.append(tmp);
		if(sb.length() == 0){
			sb.append(0);
		}

		System.out.println(sb.reverse());
	}
}
