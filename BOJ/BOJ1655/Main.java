package BOJ.BOJ1655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int start = Integer.parseInt(br.readLine());
		pq1.add(start);
		bw.write(start + "\n");

		for (int i = 2; i < N+1; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number > pq1.peek()) {
				pq2.add(number);
			} else {
				pq1.add(number);
			}
			if (i % 2 == 0) {
				while (pq1.size() != pq2.size()) {
					if (pq1.size() > pq2.size()) {
						pq2.add(pq1.poll());
					} else {
						pq1.add(pq2.poll());
					}
				}
				bw.write(Math.min(pq1.peek(), pq2.peek()) + "\n");
			} else {
				if (pq1.size() > pq2.size()) {
					bw.write(pq1.peek() + "\n");
				} else {
					bw.write(pq2.peek() + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
