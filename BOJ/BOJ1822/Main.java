package BOJ.BOJ1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n[1]; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n[0]; i++) {
            if (!map.containsKey(A[i])) {
                sb.append(A[i]).append(" ");
                count++;
            }
        }
        if (sb.length() == 0) {
            sb.append(0);
        } else {
            System.out.println(count);
        }
        System.out.println(sb);
    }
}
