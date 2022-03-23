package BOJ.BOJ17219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = bufferedReader.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		Map<String, String> password = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String[] arr = bufferedReader.readLine().split(" ");
			password.put(arr[0], arr[1]);
		}
		for (int i = 0; i < M; i++) {
	   		String key = bufferedReader.readLine();
			bufferedWriter.write(password.get(key) + "\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
