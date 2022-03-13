package BOJ.BOJ1620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		Map<String, String> pokemon = new HashMap<>();
		String[] arr = new String[N+1];
		for (int i = 1; i < N + 1; i++) {
			String monster = br.readLine();
			pokemon.put(monster, Integer.toString(i));
			arr[i] = monster;
		}
		for (int i = 0; i < M; i++) {
			String problem = br.readLine();
			if(Character.isDigit(problem.charAt(0))){
				bw.write(arr[Integer.parseInt(problem)] + "\n");
			} else {
				bw.write(pokemon.get(problem) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
