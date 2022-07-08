package BOJ.BOJ13975;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			bw.write(mergeFiles() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static long mergeFiles() throws IOException {
		int K = Integer.parseInt(br.readLine());
		long cost = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			priorityQueue.add(Long.parseLong(st.nextToken()));
		}
		while (priorityQueue.size() > 1) {
			long  a = priorityQueue.poll();
			long  b = priorityQueue.poll();
			long c = a + b;
			cost += c;
			priorityQueue.add(c);
		}
		priorityQueue.clear();
		return cost;
	}
}


