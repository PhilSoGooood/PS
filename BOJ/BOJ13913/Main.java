package BOJ.BOJ13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ13913 숨바꼭질 4
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// arr[위치][시간, 이전 위치]
		int[][] arr = new int[100001][2];
		int[] visit = new int[100001];
		Queue<Integer> Q = new LinkedList<>();
		Q.add(N);
		while(visit[K] == 0){
			int cur = Q.poll();
			visit[cur] = 1;

			if(cur+1<= 100000){
				if(arr[cur+1][0] == 0 || arr[cur+1][0] > arr[cur][0]){
					arr[cur+1][0] = arr[cur][0] + 1;
					arr[cur+1][1] = cur;
					Q.add(cur+1);
				}
			}
			if(cur-1 >= 0){
				if(arr[cur-1][0] == 0 || arr[cur-1][0] > arr[cur][0]){
					arr[cur-1][0] = arr[cur][0] + 1;
					arr[cur-1][1] = cur;
					Q.add(cur-1);
				}
			}
			if(cur*2<= 100000){
				if(arr[cur*2][0] == 0 || arr[cur*2][0] > arr[cur][0]){
					arr[cur*2][0] = arr[cur][0] + 1;
					arr[cur*2][1] = cur;
					Q.add(cur*2);
				}
			}
		}
		Stack<Integer> stack = new Stack<>();
		int i = K;
		while (true){
			stack.add(i);
			if(i == N) break;
			i = arr[i][1];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(arr[K][0] + "\n");

		while(!stack.isEmpty()){
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb.toString());


	}
}
