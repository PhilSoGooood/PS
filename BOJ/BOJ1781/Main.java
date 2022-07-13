package BOJ.BOJ1781;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Problem> problemQ = new PriorityQueue<>();
		PriorityQueue<Integer> ramenQ = new PriorityQueue<>();
		for (int i = 1; i < N + 1; i++) {
			String[] input = br.readLine().split(" ");
			int deadline = Integer.parseInt(input[0]);
			int ramen = Integer.parseInt(input[1]);
			problemQ.add(new Problem(deadline, ramen));
		}

		while (problemQ.size() != 0) {
			Problem problem = problemQ.poll();
			ramenQ.add(problem.ramen);
			if (ramenQ.size() > problem.deadline) {
				ramenQ.poll();
			}
		}
		int answer = 0;
		while (ramenQ.size() != 0) {
			answer += ramenQ.poll();
		}
		System.out.println(answer);
	}
}

class Problem implements Comparable<Problem> {
	int deadline;
	int ramen;

	public Problem(int deadline, int ramen) {
		this.deadline = deadline;
		this.ramen = ramen;
	}

	@Override
	public int compareTo(Problem q) {
		if (this.deadline < q.deadline) {
			return -1;
		} else if (this.deadline == q.deadline) {
			if (this.ramen > q.ramen) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}

