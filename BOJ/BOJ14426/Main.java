package BOJ.BOJ14426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		List<String> strings = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			strings.add(br.readLine());
		}

		int answer = 0;

		for (int i = 0; i < m; i++) {
			String prefix = br.readLine();
			for (int j = 0; j < n; j++) {
				String object = strings.get(j);
				if (object.length() < prefix.length())
					continue;
				if (object.startsWith(prefix)) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
