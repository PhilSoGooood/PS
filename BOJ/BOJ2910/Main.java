package BOJ.BOJ2910;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> count = new HashMap<>();
		Set<Integer> set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
			if (count.containsKey(num)) {
				count.put(num, count.get(num) + 1);
			} else {
				count.put(num, 1);
			}
		}
		int[] numbers = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			numbers[i] = iterator.next();
		}
		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; j < set.size() - 1 - i; j++) {
				if (count.get(numbers[j]) < count.get(numbers[j+1])) {
					int tmp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = tmp;
				}
			}
		}
		for (int number : numbers) {
			bw.write((number + " ").repeat(count.get(number)));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
