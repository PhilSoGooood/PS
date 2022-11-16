package BOJ.BOJ11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                String subStr = S.substring(i, j + 1);
                if (!map.containsKey(subStr)) {
                    map.put(subStr, subStr);
                }
            }
        }
        System.out.println(map.size());
    }
}
