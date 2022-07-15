package BOJ.BOJ1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqA = new PriorityQueue<>();
		PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			pqA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			pqB.add(Integer.parseInt(st.nextToken()));
		}
		int S = 0;
		for (int i = 0; i < N; i++) {
			S += (pqA.poll() * pqB.poll());
		}
		System.out.println(S);
	}
}
