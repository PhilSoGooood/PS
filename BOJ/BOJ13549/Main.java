package BOJ.BOJ13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dist = new int[100001];
		int[] visit = new int[100001];
		for(int i=0; i<dist.length; i++){
			dist[i] = 100001;
		}
		visit[N] = 1;
		dist[N] = 0;

		Queue<Integer> Q = new LinkedList<>();
		Q.add(N);
			while (visit[K] == 0) {
				int cur = Q.poll();
				visit[cur] = 1;
				if (cur * 2 <= 100000 && visit[cur*2] == 0) {
					if(dist[cur * 2] > dist[cur])
						dist[cur * 2] = dist[cur];
					Q.add(cur * 2);
				}
				if (cur + 1 <= 100000 && visit[cur+1] == 0) {
					if(dist[cur + 1] > dist[cur] + 1)
						dist[cur + 1] = dist[cur] + 1;
					Q.add(cur + 1);
				}
				if (cur - 1 >= 0 && visit[cur-1] == 0) {
					if(dist[cur - 1] > dist[cur] + 1)
						dist[cur - 1] = dist[cur] + 1;
					Q.add(cur - 1);
				}
			}

			System.out.println(dist[K]);
		}
	}

