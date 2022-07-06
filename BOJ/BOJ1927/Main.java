package BOJ.BOJ1927;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) {
				priorityQueue.add(x);
			} else {
				Integer root = priorityQueue.poll();
				if (root == null) {
					bw.write("0");
				} else {
					bw.write(root.toString());
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
