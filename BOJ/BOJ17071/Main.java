package BOJ.BOJ17071;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
BOJ17071 숨바꼭질 5
원래 Set 으로 중복을 줄였으나 계속해서 71% 에서 시간초과가 발생하여 구글링의 도움을 받아 짝수/홀수 접근을 구분하였음.
 */
class Main {
	public static int solution(int N, int K) throws IOException {
		Queue<Integer> Q = new LinkedList<>();
		int time = 0;

		// dist[짝수][홀수]
		boolean[][] visit = new boolean[500001][2];

		Q.add(N);
		visit[N][0] = true;

		while (!Q.isEmpty() && K <= 500000) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {

				int cur = Q.poll();

				if (time % 2 == 1) {
					if (cur == K || visit[K][1]) {
						return time;
					}

					if (cur - 1 >= 0 && !visit[cur - 1][0]) {
						visit[cur - 1][0] = true;
						Q.add(cur - 1);
					}

					if (cur + 1 <= 500000 && !visit[cur + 1][0]) {
						visit[cur + 1][0] = true;
						Q.add(cur + 1);
					}

					if (cur * 2 <= 500000 && !visit[cur * 2][0]) {
						visit[cur * 2][0] = true;
						Q.add(cur * 2);
					}
				}
				else {
					if (cur == K || visit[K][0]) {
						return time;
					}

					if (cur - 1 >= 0 && !visit[cur - 1][1]) {
						visit[cur - 1][1] = true;
						Q.add(cur-1);
					}

					if (cur + 1 <= 500000 && !visit[cur + 1][1]) {
						visit[cur + 1][1] = true;
						Q.add(cur+1);
					}

					if (cur * 2 <= 500000 && !visit[cur * 2][1]) {
						visit[cur * 2][1] = true;
						Q.add(cur*2);
					}
				}
				}
				K += ++time;
			}
			return -1;
		}

		public static void main (String[]args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			bw.write(solution(N, K) + " ");
			bw.flush();
			bw.close();
			br.close();
		}
	}

