package BOJ.BOJ1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			priorityQueue.add(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while (priorityQueue.size() > 1) {
			int a = priorityQueue.poll();
			int b = priorityQueue.poll();
			int sum = a+b;
			answer += sum;
			priorityQueue.add(sum);
		}
		System.out.println(answer);
	}
}
