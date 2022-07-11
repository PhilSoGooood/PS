package BOJ.BOJ5430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void solution() throws IOException {
		// R로 배열이 뒤집혔는지 체크
		boolean reversed = false;
		String command = br.readLine();
		int n = Integer.parseInt(br.readLine());

		// []을 제거하고 ,을 기준으로 분리 후 배열로 저장
		String[] input = br.readLine().replaceAll("[\\[\\]]", "").split(",");

		Deque<String> deque = new LinkedList<>();
		// n이 0이 아닌 경우 배열 값을 deque에 삽입
		if (n != 0) {
			Collections.addAll(deque, input);
		}

		for (int i = 0; i < command.length(); i++) {
			// 명령어가 'R'이면 reversed 바꿔주기
			if (command.charAt(i) == 'R') {
				reversed = !reversed;
			} else {
				// 배열이 비어있는데 D를 사용한 경우 에러를 출력하고 메서드 종료
				if (deque.size() == 0) {
					bw.write("error\n");
					return;
				}
				// reversed 가 참이면 뒤집힌것이므로 맨뒤를 삭제
				if (reversed) {
					deque.pollLast();
				} else {
					// 그렇지 않은 경우 원래대로 맨 앞을 삭제
					deque.pollFirst();
				}
			}
		}
		bw.write("[");
		if (deque.size() != 0 && reversed) {
			// reversed가 참인 경우 뒤집혔으므로 뒤에서부터 빼온다
			while (deque.size() > 1) {
				bw.write(deque.pollLast() + ",");
			}
			bw.write(deque.pollLast());
		} else if (deque.size() != 0 && !reversed){
			while (deque.size() > 1) {
				bw.write(deque.pollFirst() + ",");
			}
			bw.write(deque.pollFirst());
		}
		bw.write("]\n");
	}

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			solution();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
