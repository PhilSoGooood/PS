package BOJ.BOJ1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
	static StringBuilder sb = new StringBuilder();
	static int L;
	static int C;
	static char[] alphas;
	public static void solution(int cur, int idx, char[] arr, int vowelCount){
		if(cur == L){
			if(vowelCount > 0 && L - vowelCount > 1){
				for(char alpha : arr){
					sb.append(alpha);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=idx; i<C; i++){
			int isVowel = 0;
			arr[cur] = alphas[i];
			for (char vowel : VOWELS) {
				if (alphas[i] == vowel)
					isVowel = 1;
			}
			solution(cur+1, i+1, arr, vowelCount+isVowel);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		alphas = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(alphas);
		char[] arr = new char[L];
		int vowelCount = 0;
		solution(0, 0, arr, vowelCount);
		System.out.println(sb.toString());
	}
}
