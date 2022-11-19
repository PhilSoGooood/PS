package BOJ.BOJ19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken().replace(":", ""));
        int E = Integer.parseInt(stk.nextToken().replace(":", ""));
        int Q = Integer.parseInt(stk.nextToken().replace(":", ""));
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            String[] arr = input.split(" ");
            int time = Integer.parseInt(arr[0].replace(":", ""));
            if (time <= S) {
                map.put(arr[1], time);
            } else if (E <= time && time <= Q && map.containsKey(arr[1])) {
                map.remove(arr[1]);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
