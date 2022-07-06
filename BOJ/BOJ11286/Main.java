package BOJ.BOJ11286;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) ->  {
			if (Math.abs(a) < Math.abs(b)) {
				return -1;
			} else if (Math.abs(a) == Math.abs(b)) {
				if (a < b) return -1;
				else if (a > b) return 1;
				else return 0;
			} else {
				return 1;
			}
		});

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

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
