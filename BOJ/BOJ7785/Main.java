package BOJ.BOJ7785;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String leave = "leave";
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals(leave)) {
                map.remove(name);
            } else {
                map.put(name, true);
            }
        }
        map.keySet().stream().sorted(Comparator.reverseOrder()).iterator().forEachRemaining(m -> {
            try {
                bw.write(m+ "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
        br.close();
    }
}
