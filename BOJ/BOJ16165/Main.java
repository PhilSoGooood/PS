package BOJ.BOJ16165;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String memberName = br.readLine();
                map.put(memberName, teamName);
            }
        }

        for (int t = 0; t < M; t++) {
            String question = br.readLine();
            int tc = Integer.parseInt(br.readLine());
            if (tc == 0) {
                map.keySet().stream().filter(k -> map.get(k).equals(question)).sorted().iterator()
                    .forEachRemaining(
                        k -> {
                            try {
                                bw.write(k + "\n");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    );
            } else {
                bw.write(map.get(question) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
