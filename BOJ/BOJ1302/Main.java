package BOJ.BOJ1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] array = new String[N];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			array[i] = book;
			if (!map.containsKey(book)) {
				map.put(book, 1);
			} else {
				map.put(book, map.get(book)+1);
			}
		}
		Arrays.sort(array);
		int maxNum = 0;
		String title = "";
		for (String book : map.keySet()) {
			if (map.get(book) > maxNum) {
				maxNum = map.get(book);
				title = book;
			} else if (map.get(book) == maxNum && Arrays.asList(array).indexOf(book) < Arrays.asList(array).indexOf(title)) {
				title = book;
			}
		}
		System.out.println(title);
	}
}
