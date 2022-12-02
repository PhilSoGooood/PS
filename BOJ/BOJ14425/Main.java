package BOJ.BOJ14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, input);
        }
        for (int i = 0; i < M; i++) {
            if (map.containsKey(br.readLine())) ans++;
        }
        System.out.println(ans);
    }
}
