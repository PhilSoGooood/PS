package BOJ.BOJ11279;

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
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				Integer root = priorityQueue.poll();
				if (root == null) {
					bw.write("0");
				} else {
					bw.write(root.toString());
				}
				bw.write("\n");
			} else {
				priorityQueue.add(x);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
