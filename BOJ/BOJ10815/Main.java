package BOJ.BOJ10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ10815 숫자카드
이진탐색 활용
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		for(int i=0; i<N; i++){
			cards[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(cards);
		int M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		loop:
		for(int i=0; i<M; i++){
			int obj = Integer.parseInt(stk.nextToken());
			int start = 0, end = N-1;
			int mid;
			while(start <= end){
				mid = (start + end) / 2;
				if(cards[mid] == obj) {
					sb.append(1 + " ");
					continue loop;
				} else if (obj < cards[mid]){
					end = mid -1;
				} else {
					start = mid + 1;
				}
			}
			sb.append(0 + " ");
		}
		System.out.println(sb);
	}
}
