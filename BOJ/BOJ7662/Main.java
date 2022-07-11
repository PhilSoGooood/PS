package BOJ.BOJ7662;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++)  {
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				if (command.equals("I")) {
					// 명령어가 "I"인 경우 맵에 숫자 삽입
					treeMap.put(number, treeMap.getOrDefault(number, 0) +1);
				} else {
					// 명령어가 "D"인 경우
					int num = 0;
					if (treeMap.size() == 0) {
						// 맵이 비어있는 경우 continue
						continue;

					} else if (number == 1) {
						// 숫자가 1인 경우 최대값 반환
						num = treeMap.lastKey();
					} else {
						// 숫자가 -1인 경우 최소값 반환
						num = treeMap.firstKey();
					}
					// 해당 숫자의 갯수(value)를 줄여준다
					treeMap.put(num, treeMap.get(num) - 1);

					// 해당 숫자의 갯수가 0인 경우 맵에서 삭제해준다
					if (treeMap.get(num) == 0) {
						treeMap.remove(num);
					}
				}
			}
			// 맵이 비어있는 경우 "EMPTY" 출력
			if (treeMap.size() == 0) {
				bw.write("EMPTY\n");
			} else {
				//	그렇지 않은 경우 최대값, 최소값을 가져온다
				bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
			}
			// 다음 테스트케이스를 위해 맵을 비워준다.
			treeMap.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
