package BOJ.BOJ2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			priorityQueue.add(Integer.parseInt(br.readLine()));
		}
		int maxWeight = 0;
		int w;
		int k = 0;
		while (priorityQueue.size() != 0) {
			int rope = priorityQueue.poll();
			w = rope * ++k;
			if (maxWeight < w) maxWeight = w;
		}
		System.out.println(maxWeight);
	}
}
