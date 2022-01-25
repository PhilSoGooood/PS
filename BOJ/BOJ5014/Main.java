package BOJ.BOJ5014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ5014 스타트링크
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] arr = new int[F + 1];
		int cur = S;
		arr[cur] = 1;
		int next;

		boolean stair = false;
		while (cur != G) {
			next = cur > G ? cur - D : cur + U;

			if (next > F) {
				next = cur - D;
			} else if (next < 1)
				next = cur + U;

			if(next > F || next < 1 || arr[next] != 0){
				stair = !stair;
				break;
			}
			arr[next] = arr[cur] + 1;
			cur = next;
		}
		if (stair) {
			System.out.println("use the stairs");
		} else
			System.out.println(arr[cur] - 1);

	}
}
